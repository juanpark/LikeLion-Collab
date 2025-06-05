package com.sec01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sec01.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}