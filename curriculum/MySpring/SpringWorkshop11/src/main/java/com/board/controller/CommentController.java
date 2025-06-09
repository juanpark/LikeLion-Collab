package com.board.controller;

import com.board.entity.Comment;
import com.board.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{postId}")
    public void addComment(@PathVariable Long postId, @RequestBody Comment comment) {
        commentService.addComment(postId, comment);
    }
}