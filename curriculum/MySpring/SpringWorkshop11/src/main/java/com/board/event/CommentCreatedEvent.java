package com.board.event;

public class CommentCreatedEvent {
    private final Long postId;
    private final String writer;
    private final String content;

    public CommentCreatedEvent(Long postId, String writer, String content) {
        this.postId = postId;
        this.writer = writer;
        this.content = content;
    }

    public Long getPostId() {
        return postId;
    }

    public String getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }
}