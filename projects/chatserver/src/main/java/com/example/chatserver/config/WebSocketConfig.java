package com.example.chatserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 클라이언트 연결
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*") // 모든 origins 허가 (for dev)
                .withSockJS(); // 웹소켓 지원 안하는 브라우저 대비
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 클라이언트가 /topic/무언가로 메시지를 받을 수 있게 서버 안에 작은 메시지 전달 기능을 켜는 것
        registry.enableSimpleBroker("/topic");

        // 클라이언트가 보내는 모든 메세지는 /app으로 시작
        registry.setApplicationDestinationPrefixes("/app");
    }
}