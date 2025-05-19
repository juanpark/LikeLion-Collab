package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02MTest {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans02.xml");

    Person g7 = context.getBean("g7",Person.class);
    System.out.println("**** 강사 출석 ****");
    g7.classWork();

    System.out.println("======================================");

    Person student = context.getBean("student",Person.class);
    System.out.println("**** 학생 출석 ****");
    student.classWork();
  }

}
