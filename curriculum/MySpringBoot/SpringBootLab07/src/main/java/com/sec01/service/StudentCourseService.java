package com.sec01.service;

import com.sec01.entity.Student;
import com.sec01.entity.Course;
import com.sec01.repository.StudentRepository;
import com.sec01.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentCourseService {

/*	// 필드 주입 (권장사항 아님) 보다는 생성자 주입을 권장함 	-> 런타임까지 의존석 누락 유무를 감지 못한다.
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;
*/
	// 생성자 주입 (권장 사항)	-> final로 불변 유지, 컴파일 타입시 확인가능, 컴파일 시점 명확하게 주소 확인!
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	
	public StudentCourseService(StudentRepository studentRepository, CourseRepository courseRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

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
	/*
	// [7] 특정 과목명을 수강하는 학생 목록 조회
	public List<Student> getStudentsByCourseTitle(String courseTitle) {
        return studentRepository.findByCourseTitle(courseTitle);
    }
	
	// [8]
	public List<StudentCourseDto> getStudentCourseList() {
		return studentRepository.findStudentCourseDtoList();
	}*/
}