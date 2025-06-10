package com.board.repository;

import com.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteByPostId(Long postId);
}
