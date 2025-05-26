package com.lab01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lab01.entity.Student;
import com.lab01.repository.StudentRepository;

@SpringBootTest
public class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void testSaveStudent() {
		Student student = new Student();
		student.setName("John");
		student.setGrade(2);
		
		Student savedStudent = studentRepository.save(student);
		assertThat(savedStudent.getId()).isNotNull();
		assertThat(savedStudent.getName()).isEqualTo("John");
	}
	@Test
	public void testMy() {
		assertThat("John").isEqualTo("John");
	}
}