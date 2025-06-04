package com.sec01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//학생명 + 수강명
@AllArgsConstructor
public @Data class StudentCourseDto {
	private String studentName;
	private String courseTitle;
	
	
}
