package com.sec01.service;

import com.sec01.entity.Student;
import com.sec01.dto.StudentCourseDto;
import com.sec01.entity.Course;
import com.sec01.repository.StudentRepository;
import com.sec01.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentCourseService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	// [1] 전체 학생 목록 조회
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	// [2]전체 과목 목록 조회
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	// [3] 학생 추가 (기존 강의에 연결)
	public void addStudent(String name, List<Long> courseIds) {
		Student student = new Student();
		student.setName(name);

		if (courseIds != null && !courseIds.isEmpty()) {
			List<Course> courses = courseRepository.findAllById(courseIds);

			for (Course course : courses) {
				student.getCourses().add(course);
				course.getStudents().add(student);
			}
		}

		studentRepository.save(student);
	}

	// [4] 과목 추가 (과목만)
	public void addCourse(String title) {
		Course course = new Course();
		course.setTitle(title);
		courseRepository.save(course);
	}

	// [5] 학생 삭제
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	// [6] 과목 삭제
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
	
	// [7] 특정 과목명을 수강하는 학생 목록 조회
	public List<Student> getStudentsByCourseTitle(String courseTitle) {
        return studentRepository.findByCourseTitle(courseTitle);
    }
	
	// [8]
	public List<StudentCourseDto> getStudentCourseList() {
		return studentRepository.findStudentCourseDtoList();
	}
}