package com.board.service;

import com.board.entity.Comment;
import com.board.event.CommentCreatedEvent;
import com.board.repository.CommentRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ApplicationEventPublisher publisher;

    public CommentService(CommentRepository commentRepository, ApplicationEventPublisher publisher) {
        this.commentRepository = commentRepository;
        this.publisher = publisher;
    }

    public void addComment(Long postId, Comment comment) {
        comment.setPostId(postId);
        commentRepository.save(comment);

        publisher.publishEvent(new CommentCreatedEvent(postId, comment.getWriter(), comment.getContent()));
        System.out.println("비동기 이벤트 발행 완료");
    }
}