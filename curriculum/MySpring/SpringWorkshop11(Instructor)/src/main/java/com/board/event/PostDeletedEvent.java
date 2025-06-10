package com.board.event;

import lombok.Getter;

@Getter
public class PostDeletedEvent {
    private final Long postId;

    public PostDeletedEvent(Long postId) {
        this.postId = postId;
    }
}
