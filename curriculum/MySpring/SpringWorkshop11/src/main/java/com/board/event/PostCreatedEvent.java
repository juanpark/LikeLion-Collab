package com.board.event;

public class PostCreatedEvent {
    private final Long postId;
    private final String title;

    public PostCreatedEvent(Long postId, String title) {
        this.postId = postId;
        this.title = title;
    }

    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }
}