package com.sec01.controller;

import com.sec01.entity.Student;
import com.sec01.dto.StudentCourseDto;
import com.sec01.entity.Course;
import com.sec01.service.StudentCourseService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentCourseController {

    @Autowired
    private StudentCourseService service;

    // [1] 모든 학생 목록과 과목 목록을 함께 조회한다.
    @GetMapping("/students")
    public String showStudents(Model model) {
        List<Student> students = service.getAllStudents();
        List<Course> courses = service.getAllCourses();
        model.addAttribute("students", students);
        model.addAttribute("courses", courses); // 과목도 같이 넘기기
        return "students";
    }

    // [2] 모든 과목 목록을 조회한다.
    @GetMapping("/courses")
    public String showCourses(Model model) {
        List<Course> courses = service.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }

    // [3] 학생과 과목을 동시에 추가한다.
    @PostMapping("/students")
    public String addStudent(@RequestParam("name") String name,
                             @RequestParam(value = "courseIds", required = false) List<Long> courseIds) {
        if (courseIds == null || courseIds.isEmpty()) {
            // 아무 과목도 선택 안 하면 처리 안 하거나 기본 처리
        } else {
            service.addStudent(name, courseIds);
        }
        return "redirect:/students";
    }

    // [4] 과목을 단독으로 추가한다.
    @PostMapping("/courses")
    public String addCourse(@RequestParam("title") String title) {
        service.addCourse(title);
        return "redirect:/courses";
    }

    // [5] 특정 학생을 삭제한다.
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }

    // [6] 특정 과목을 삭제한다.
    @GetMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
        return "redirect:/courses";
    }
    
    //[7] 특정 과목명을 수강하는 학생 목록을 조회하는 기능
    @GetMapping("/students/by-course")
    public String showStudentsByCourse(@RequestParam("title") String courseTitle, Model model) {
        List<Student> students = service.getStudentsByCourseTitle(courseTitle);
        model.addAttribute("students", students);
        model.addAttribute("courseTitle", courseTitle);
        return "students-by-course";
    }
    
    // [8]
    @GetMapping("/students/courses")
    public String showStudentCourseList(Model model) {
    	List<StudentCourseDto> res = service.getStudentCourseList();
    	model.addAttribute("studentscourses", res);
    	return "students-course-list";
    }
}
