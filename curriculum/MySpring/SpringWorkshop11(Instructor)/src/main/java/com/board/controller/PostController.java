package com.board.controller;

import com.board.entity.Post;
import com.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping
    public List<Post> all() {
        return postService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
