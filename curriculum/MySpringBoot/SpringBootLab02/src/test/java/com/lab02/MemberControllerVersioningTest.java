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
public class MemberControllerVersioningTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getAllMembersV1() throws Exception {
		mockMvc.perform(get("/v1/members")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").isArray());
	}
	
	@Test
	void getAllMembersV2() throws Exception {
		mockMvc.perform(get("/v2/members")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			// V2 에서는 DTO 만 반환하므로 id 와 name 만 검증
			.andExpect(jsonPath("$[0].id").exists())
			.andExpect(jsonPath("$[0].name").exists());
	}
	
}
