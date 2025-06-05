package com.sec01.controller;

import com.sec01.entity.Student;
import com.sec01.dto.*;
import com.sec01.entity.Course;
import com.sec01.service.StudentCourseService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentCourseController {

    private final StudentCourseService service;

    // [1] 모든 학생 + 과목 목록 조회 (courses 포함)
    @GetMapping("/students-with-courses")
    public StudentsAndCoursesResponse showStudents() {
        List<Student> students = service.getAllStudents(); //DB return Entity
        List<Course> courses = service.getAllCourses(); //DB return Entity
        
        // [1-1] 학생 응답 DTO 변환 
        List<StudentResponseDto> studentDtos = students.stream()
        	.map(student -> new StudentResponseDto(
        			student.getId(),
        			student.getName(),
        			student.getCourses().stream()
        				.map(c -> new CourseDto(c.getId(), c.getTitle()))
        				.collect(Collectors.toList())
        	))
        	.collect(Collectors.toList());
        
        return new StudentsAndCoursesResponse(studentDtos, courses);
        			
    }
    
    // [2] 모든 과목 목록 조회
    @GetMapping("/courses")
    public List<Course> showCourses() {
        return service.getAllCourses();
    }
    
    // [3] 학생 추가 (학생 이름 + 수강
    @PostMapping("/students")
    public void addStudent(@RequestBody StudentRequestDto dto) {
        service.addStudent(dto.getName(), dto.getCourseIds());
    }
    
    // [4] 
    @PostMapping("/courses")
    public void addCourse(@RequestBody CourseDto course) {
        service.addCourse(course.getTitle());
    }
    
    // [5] 특정 학생 삭제
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
    
    // [6] 특정 과목 삭제
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }
}
