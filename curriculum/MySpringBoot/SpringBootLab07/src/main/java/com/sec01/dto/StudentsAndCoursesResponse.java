package com.sec01.dto;

import java.util.List;

import com.sec01.entity.Course;
import com.sec01.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentsAndCoursesResponse {
    private List<StudentResponseDto> students;
    private List<Course> courses;
}