package com.sec02.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.sec01.entity.Post;
import com.sec02.entity.Comment;
import com.sec02.repository.CommentRepository;
import com.sec01.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    private final CommentRepository commentRepo;
    private final PostRepository postRepo;

    // [1] Create a comment for a given post
    @PostMapping
    public Comment addComment(@PathVariable Long postId, @RequestBody Comment comment) {
        Post post = postRepo.findById(postId).orElseThrow();
        comment.setPost(post);
        return commentRepo.save(comment);
    }

    // [2] Get all comments for a given post
    @GetMapping
    public List<Comment> getComments(@PathVariable Long postId) {
        return commentRepo.findByPostId(postId);
    }

    // [3] Update a comment
    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody Comment newComment) {
        Comment comment = commentRepo.findById(commentId).orElseThrow();
        comment.setContent(newComment.getContent());
        return commentRepo.save(comment);
    }

    // [4] Delete a comment
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentRepo.deleteById(commentId);
    }
}