package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext04.xml");
        GreetService svc = ctx.getBean("greetService", GreetService.class);
        svc.sayHello();
    }
}
