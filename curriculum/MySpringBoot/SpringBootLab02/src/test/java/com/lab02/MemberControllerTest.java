package com.lab02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void createMember_성공() throws Exception {
		String requestBody = "{\"name\":\"홍길동\", \"email\":\"hong@test.com\"}";
		
		mockMvc.perform(post("/members")
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.name").value("홍길동"))
			.andExpect(jsonPath("$.email").value("hong@test.com"));
	}
	
	@Test
	void createMember_실패이름누락() throws Exception {
		String requestBody = "{\"email\":\"hong@test.com\"}";
	
		mockMvc.perform(post("/members")
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody))
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.message").value("이름은 필수입니다."));
	}
	
	@Test
	void createMember_실패이메일형식() throws Exception {
		String requestBody = "{\"name\":\"홍길동\", \"email\":\"wrong-email\"}";
		
		mockMvc.perform(post("/members")
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody))
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.message").value("올바른 이메일 형식이어야 합니다."));
	}
}
