package com.sec01.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public @Data class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name; 

	// student_id로 중간 테이블에 연결 joinColumns
	// Course는 course_id로 연결 inverseJoinColumns
	@ManyToMany
	@JoinTable(
		name = "student_course",								//중간테이블 이름
		joinColumns = @JoinColumn(name = "student_id"),			//현재 클래스=Student FK
		inverseJoinColumns = @JoinColumn(name = "course_id")	//반대 클래스=Course FK
	)
	@JsonIgnore 	// Json 타입으로 진행될 때 특정 필드를 무시 -> 무한 재귀 방지
	private List<Course> courses = new ArrayList<>();
}