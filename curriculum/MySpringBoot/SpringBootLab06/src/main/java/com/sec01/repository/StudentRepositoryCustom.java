package com.sec01.repository;

import java.util.List;

import com.sec01.dto.StudentCourseDto;
import com.sec01.entity.Student;

public interface StudentRepositoryCustom {
	List<Student> findByCourseTitle(String courseTitle);
	List<StudentCourseDto> findStudentCourseDtoList();
}
