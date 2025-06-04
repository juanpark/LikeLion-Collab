package com.sec02.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sec01.entity.Post;
import com.sec01.repository.PostRepository;
import com.sec02.entity.Comment;
import com.sec02.repository.CommentRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) // MockMvc 테스트 시 Spring Security 해제
public class CommentControllerTest {

    @Autowired 
    private MockMvc mockMvc;
    
    @Autowired 
    private PostRepository postRepository;
    
    @Autowired 
    private CommentRepository commentRepository;
    
    @Autowired 
    private ObjectMapper objectMapper;

    private Long postId;

    @BeforeEach
    void setUp() {
        commentRepository.deleteAll();
        postRepository.deleteAll();

        Post post = new Post();
        post.setTitle("Test Post");
        post.setContent("Post content");
        postId = postRepository.save(post).getId();
    }

    @Test
    void testAddAndGetComments() throws Exception {
        Comment comment = new Comment();
        comment.setContent("First comment");

        // Add comment
        mockMvc.perform(post("/posts/{postId}/comments", postId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comment)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("First comment"));

        // Get comment
        mockMvc.perform(get("/posts/{postId}/comments", postId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].content").value("First comment"));
    }

    @Test
    void testUpdateComment() throws Exception {
        // Given: save original comment
        Comment saved = new Comment();
        saved.setContent("Before edit");
        saved.setPost(postRepository.findById(postId).orElseThrow());
        Long commentId = commentRepository.save(saved).getId();

        // When: update it
        Comment updated = new Comment();
        updated.setContent("After edit");

        mockMvc.perform(put("/posts/{postId}/comments/{commentId}", postId, commentId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("After edit"));
    }

    @Test
    void testDeleteComment() throws Exception {
        // Given: a comment to delete
        Comment comment = new Comment();
        comment.setContent("To be deleted");
        comment.setPost(postRepository.findById(postId).orElseThrow());
        Long commentId = commentRepository.save(comment).getId();

        // When: delete it
        mockMvc.perform(delete("/posts/{postId}/comments/{commentId}", postId, commentId))
                .andExpect(status().isOk());

        // Then: list should be empty
        mockMvc.perform(get("/posts/{postId}/comments", postId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}