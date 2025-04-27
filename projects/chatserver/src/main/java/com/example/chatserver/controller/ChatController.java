package com.example.chatserver.controller;

import com.example.chatserver.model.ChatMessage;
import com.example.chatserver.repository.ChatMessageRepository;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;  
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageRepository chatMessageRepository;
    private final AtomicInteger connectedUsers = new AtomicInteger(0);
    

    public ChatController(SimpMessagingTemplate messagingTemplate, ChatMessageRepository chatMessageRepository) {
        this.messagingTemplate = messagingTemplate;
        this.chatMessageRepository = chatMessageRepository;
    }

    @MessageMapping("/chat.sendMessage")    // 클라이언트 발송 /app/chat.sendMessage
    @SendTo("/topic/public")                // 서버 방송 /topic/public
    public ChatMessage sendMessage(ChatMessage message) {
        // 타임스탬프 추가
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        message.setTimestamp(timestamp);

        // MySQL 저장하기
        chatMessageRepository.save(message);

        return message; // just echoing the message back for now
    }

    @MessageMapping("/chat.history")
    public void sendHistory() {
        List<ChatMessage> history = chatMessageRepository.findAll();
        for (ChatMessage pastMessage : history) {
            messagingTemplate.convertAndSend("/topic/public", pastMessage);
        }
    }

    // 챗 히스토리 로딩하기
    @GetMapping("/chat/history")
    @ResponseBody
    public List<ChatMessage> getChatHistory() {
        return chatMessageRepository.findAll(); // 저장 된 챗 리턴하기
    }

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        connectedUsers.incrementAndGet();
        broadcastUserCount();
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        connectedUsers.decrementAndGet();
        broadcastUserCount();
    }

    private void broadcastUserCount() {
        messagingTemplate.convertAndSend("/topic/userCount", connectedUsers.get());
    }
    
    @GetMapping("/chat/userCount")
    @ResponseBody
    public int getCurrentUserCount() {
        return connectedUsers.get();
    }
}