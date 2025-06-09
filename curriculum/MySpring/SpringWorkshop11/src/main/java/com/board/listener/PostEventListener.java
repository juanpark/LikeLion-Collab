package com.board.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.board.event.PostCreatedEvent;

@Component
public class PostEventListener {

    @EventListener
    public void handlePostCreated(PostCreatedEvent event) {
        System.out.println("이벤트 리스너 실행됨: " + event.getTitle());
    }
}