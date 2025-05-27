package com.lab02;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.lab02.controller.TestController;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TestController.class)  
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHandle() throws Exception {
        mockMvc.perform(get("/handle")) // GET /handle 요청
            .andExpect(status().isCreated()) // 201 Created 응답
            .andExpect(header().string("Location", containsString("/api/new-resource/123"))) // Location 헤더 검증
            .andExpect(header().string("MyResponseHeader", "MyValue")) // 커스텀 헤더 검증
            .andExpect(content().string("Hello World")); // 본문 검증
    }
}
