package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {

	int insertStudent(Student s);
	int updateStudent(Student s);
	int deleteStudent(Student s);
	List<Student> selectAllStudent();
	Student searchByName(Student s);
	List<Student> getStudentByPage(int page, int size);
}
