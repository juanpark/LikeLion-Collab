package com.sec01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sec01.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {}