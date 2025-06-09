package com.board.controller;

import com.board.entity.Post;
import com.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // [1] CREATE POST
    // POST http://localhost:8080/posts?title=EventTest&content=Testing event publishing
    @PostMapping
    public Post create(@RequestBody Post post) {
        return postService.createPost(post);
    }

    // [2] GET ALL POSTS
    @GetMapping
    public List<Post> all() {
        return postService.getAllPosts();
    }

    // [3] DELETE POST BY ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.deletePost(id);
    }
}