package com.sec01.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sec01.entity.Post;
import com.sec01.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) // MockMvc 테스트 시 Spring Security 해제
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        postRepository.deleteAll(); // Clean DB before each test
    }

    @Test
    @DisplayName("게시글 생성 테스트")
    void testCreatePost() throws Exception {
        Post post = new Post(null, "Test Title", "Test Content");

        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Title")));
    }

    @Test
    @DisplayName("전체 게시글 조회 테스트")
    void testGetAllPosts() throws Exception {
        postRepository.save(new Post(null, "Hello", "World"));

        mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }

    @Test
    @DisplayName("게시글 수정 테스트")
    void testUpdatePost() throws Exception {
        Post saved = postRepository.save(new Post(null, "Old Title", "Old Content"));
        Long id = saved.getId();

        Post updated = new Post(id, "New Title", "New Content");

        mockMvc.perform(put("/posts/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("New Title")));
    }

    @Test
    @DisplayName("게시글 삭제 테스트")
    void testDeletePost() throws Exception {
        Post saved = postRepository.save(new Post(null, "To Delete", "Bye"));
        Long id = saved.getId();

        mockMvc.perform(delete("/posts/" + id))
                .andExpect(status().isOk());

        Optional<Post> result = postRepository.findById(id);
        assert result.isEmpty(); // JUnit assertion
    }
}