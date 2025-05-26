package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpServiceTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        EmpService service = ctx.getBean(EmpService.class);
        service.insertThenFail("실패될이름");
    }
}