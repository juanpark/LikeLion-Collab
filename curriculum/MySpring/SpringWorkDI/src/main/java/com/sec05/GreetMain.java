package com.sec05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext05.xml");
        GreetManager gm = ctx.getBean("greetManager", GreetManager.class);
        gm.execute();
    }
}
