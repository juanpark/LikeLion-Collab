package com.lab06;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.sec01.entity.Student;
import com.sec01.entity.Course;
import com.sec01.repository.CourseRepository;
import com.sec01.repository.StudentRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentCourseControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Test
	void testShowAllPages() throws Exception {
		// 테스트용 학생 / 강의 저장
		Student student = new Student();
		student.setName("Hone Gil Dong");
		studentRepository.save(student);
		
		Course course = new Course();
		course.setTitle("Java Programming");
		courseRepository.save(course);
		
		// 학생 목록 페이지 테스트
		mockMvc.perform(get("/students"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hong Gil Dong")));
		
		// 강의 목록 페이지 테스트
		mockMvc.perform(get("/courses"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Java Programming")));
		
		
	}
}
