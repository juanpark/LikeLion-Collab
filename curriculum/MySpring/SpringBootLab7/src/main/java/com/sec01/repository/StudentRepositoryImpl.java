package com.sec01.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.PathBuilder;
import com.sec01.dto.StudentCourseDto;
import com.sec01.entity.QCourse;
import com.sec01.entity.QStudent;
import com.sec01.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public StudentRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Student> findByCourseTitle(String courseTitle) {
        QStudent student = QStudent.student;
        QCourse course = QCourse.course;

        return queryFactory
                .selectFrom(student)
                .join(student.courses, course)
                .where(course.title.eq(courseTitle))
                .fetch();
    }

	@Override
	public List<StudentCourseDto> findStudentCourseDtoList() {
       QStudent student = QStudent.student;
       QCourse course = QCourse.course;

        return queryFactory
        		.select(Projections.constructor(StudentCourseDto.class, student.name, course.title))
        		.from(student)
        		.join(student.courses, course)
        		.fetch();
	}
}