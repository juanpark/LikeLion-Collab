package com.example.chatserver.controller;

import com.example.chatserver.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")    // 클라이언트 발송 /app/chat.sendMessage
    @SendTo("/topic/public")                // 서버 방송 /topic/public
    public ChatMessage sendMessage(ChatMessage message) {
        return message; // just echoing the message back for now
    }
}