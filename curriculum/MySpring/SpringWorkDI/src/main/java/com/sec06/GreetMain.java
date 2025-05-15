package com.sec06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext06.xml");
        GreetService svc = ctx.getBean("greetService", GreetService.class);
        svc.sayHello();
    }
}
