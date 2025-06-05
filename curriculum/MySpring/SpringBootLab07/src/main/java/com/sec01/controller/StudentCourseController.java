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

    @GetMapping("/students-with-courses")
    public StudentsAndCoursesResponse showStudents() {
        List<Student> students = service.getAllStudents();
        List<Course> courses = service.getAllCourses();
        
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
    
    @GetMapping("/courses")
    public List<Course> showCourses() {
        return service.getAllCourses();
    }
    
    @PostMapping("/students")
    public void addStudent(@RequestBody StudentRequestDto dto) {
        service.addStudent(dto.getName(), dto.getCourseIds());
    }
    
    @PostMapping("/courses")
    public void addCourse(@RequestBody CourseDto course) {
        service.addCourse(course.getTitle());
    }
    
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
    
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }
}
