package com.test01;

import java.util.List;

public class StudentService {
    private List<Student> students;

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void printAllInfo() {
        students.forEach(s -> System.out.println(s.studentInfo()));
    }

    public void printStats() {
        double avgAge = students.stream().mapToInt(Student::getAge).average().orElse(0);
        double avgHeight = students.stream().mapToInt(Student::getHeight).average().orElse(0);
        double avgWeight = students.stream().mapToInt(Student::getWeight).average().orElse(0);

        System.out.printf("\n평균 나이: %.3f\n", avgAge);
        System.out.printf("평균 신장: %.3f\n", avgHeight);
        System.out.printf("평균 몸무게: %.3f\n", avgWeight);
    }
}
