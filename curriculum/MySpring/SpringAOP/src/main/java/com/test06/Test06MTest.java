package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06MTest {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans06.xml");
    Person student = context.getBean("student", Person.class);

    System.out.println("***학생 수업 시작***");
//    student.homeWork();
    student.classWork();
//    student.meeting("팀 프로젝트");
//    ((Student)student).study();
//    ((Student)student).relax();
//    System.out.println(((Student)student).getScore());

    ((ClassPathXmlApplicationContext) context).close();


  }

}
