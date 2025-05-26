package com.lab01.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab01.entity.Student;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	//Json 형태로 변환용
	@Autowired
	private ObjectMapper mapper;
	
	private Student student;
	
	//테스트 이전에 레코드를 인서트 해보자
	@BeforeEach
	void setUp() {
		student = new Student();
		student.setGrade(6);
		student.setName("8888");
	}
	/*
	 *  1) Test student registration
	 *  (POST /students)
	 */	
	@Test
	public void createStudent() throws Exception{
		mockMvc.perform(post("/students")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(student)))
				.andExpect(status().isOk()) //201 Created, 200 isOk()
				.andExpect(jsonPath("$.name").value(student.getName()))
				.andExpect(jsonPath("$.grade").value(student.getGrade()));
				
	}
	
	
	
	/*
	 * 	2) Test student list
	 */
	@Test
	public void getAll() throws Exception {
		mockMvc.perform(get("/students"))
				.andExpect(status().isOk());
	}
	
	
	
}
