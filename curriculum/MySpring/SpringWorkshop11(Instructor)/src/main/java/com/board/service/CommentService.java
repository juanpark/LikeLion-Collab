package com.board.service;

import com.board.entity.Comment;
import com.board.entity.Post;
import com.board.event.CommentCreatedEvent;
import com.board.repository.CommentRepository;
import com.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ApplicationEventPublisher publisher;

    public Comment addComment(Long postId, Comment comment) {
        Post post = postRepository.findById(postId).orElseThrow();
        comment.setPost(post);
        Comment saved = commentRepository.save(comment);
        publisher.publishEvent(new CommentCreatedEvent(saved.getWriter()));
        return saved;
    }
}
