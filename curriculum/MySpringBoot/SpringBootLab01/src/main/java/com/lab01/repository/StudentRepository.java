package com.lab01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab01.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	

}
