package com.example.chatserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Client will connect here
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*") // allow all origins (for dev)
                .withSockJS(); // fallback for browsers that don't support native WebSocket
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Enable simple in-memory broker for messages with /topic prefix
        registry.enableSimpleBroker("/topic");

        // All messages sent from client must start with /app
        registry.setApplicationDestinationPrefixes("/app");
    }
}