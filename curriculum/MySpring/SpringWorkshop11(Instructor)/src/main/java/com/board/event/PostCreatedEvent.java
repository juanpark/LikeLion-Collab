package com.board.event;

import lombok.Getter;

@Getter
public class PostCreatedEvent {
    private final String title;

    public PostCreatedEvent(String title) {
        this.title = title;
    }
}
