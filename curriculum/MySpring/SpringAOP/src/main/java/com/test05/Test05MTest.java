package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05MTest {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans05.xml");
    Person student = context.getBean("student",Person.class);

    System.out.println("***학생 수업 시작***");
    student.homeWork();
    student.classWork();
  }
}
