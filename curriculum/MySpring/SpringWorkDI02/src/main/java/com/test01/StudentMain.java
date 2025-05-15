package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext01.xml");
        StudentService service = ctx.getBean("studentService", StudentService.class);
        service.printAllInfo();
        service.printStats();
    }
}
