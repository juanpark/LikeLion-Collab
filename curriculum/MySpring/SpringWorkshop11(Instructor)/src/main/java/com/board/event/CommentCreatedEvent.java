package com.board.event;

import lombok.Getter;

@Getter
public class CommentCreatedEvent {
    private final String writer;

    public CommentCreatedEvent(String writer) {
        this.writer = writer;
    }
}
