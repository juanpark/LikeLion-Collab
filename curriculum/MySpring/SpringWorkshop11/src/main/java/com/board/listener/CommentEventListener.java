package com.board.listener;

import com.board.event.CommentCreatedEvent;
import com.board.event.PostDeletedEvent;
import com.board.repository.CommentRepository;

import org.springframework.scheduling.annotation.Async;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CommentEventListener {
	
	private final CommentRepository commentRepository;

    public CommentEventListener(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
	
    @Async
    @EventListener
    public void handle(CommentCreatedEvent event) {
        try {
            Thread.sleep(2000); // simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("댓글 이벤트 처리 중... by " + event.getWriter());
    }
    
    @EventListener
    public void onPostDeleted(PostDeletedEvent event) {
        System.out.println("해당 게시글의 댓글 삭제 실행: postId = " + event.getPostId());
        commentRepository.deleteByPostId(event.getPostId());
    }
}