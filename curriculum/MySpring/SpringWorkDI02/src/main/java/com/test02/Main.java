package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext02.xml");
        EmployeeService service = ctx.getBean("employeeService", EmployeeService.class);
        service.printAllEmployees();
    }
}
