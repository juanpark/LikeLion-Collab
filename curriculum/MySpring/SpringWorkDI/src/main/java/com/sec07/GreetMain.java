package com.sec07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext07.xml");
        Greet greet = ctx.getBean("morningGreet", Greet.class);
        System.out.println(greet.greeting());
    }
}
