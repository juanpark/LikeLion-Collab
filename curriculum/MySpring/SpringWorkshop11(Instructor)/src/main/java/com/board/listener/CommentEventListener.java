package com.board.listener;

import com.board.event.CommentCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommentEventListener {

    @Async
    @EventListener
    public void handle(CommentCreatedEvent event) {
        log.info("Async Comment Created Event: {}", event.getWriter());
    }
}
