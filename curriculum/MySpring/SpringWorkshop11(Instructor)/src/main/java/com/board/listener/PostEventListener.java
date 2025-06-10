package com.board.listener;

import com.board.event.PostCreatedEvent;
import com.board.event.PostDeletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PostEventListener {

    @EventListener
    public void handleCreated(PostCreatedEvent event) {
        log.info("Post Created Event Received: {}", event.getTitle());
    }

    @EventListener
    public void handleDeleted(PostDeletedEvent event) {
        log.info("Post Deleted Event Received: {}", event.getPostId());
    }
}
