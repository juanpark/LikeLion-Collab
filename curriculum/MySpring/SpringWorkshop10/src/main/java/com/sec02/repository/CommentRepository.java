package com.sec02.repository;

import com.sec02.entity.Comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	 List<Comment> findByPostId(Long postId); // CommentController의 getComments 메서드를 위해
}
