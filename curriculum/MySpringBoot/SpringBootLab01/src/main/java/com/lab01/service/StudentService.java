package com.lab01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab01.entity.Student;
import com.lab01.repository.StudentRepository;

@Service
public class StudentService {
	
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public Student save(Student student) {
		return studentRepository.saveAndFlush(student);
	}
	
	public Student findById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
}
