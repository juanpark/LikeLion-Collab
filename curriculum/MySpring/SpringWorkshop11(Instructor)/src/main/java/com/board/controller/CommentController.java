package com.board.controller;

import com.board.entity.Comment;
import com.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{postId}")
    public Comment add(@PathVariable Long postId, @RequestBody Comment comment) {
        return commentService.addComment(postId, comment);
    }
}
