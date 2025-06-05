package com.sec01.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentResponseDto {
    private Long id;
    private String name;
    private List<CourseDto> courses;
}