package com.sec02;

import org.springframework.context.ApplicationContext;
import com.sec01.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext02.xml");
        Greet greet = ctx.getBean("eveningGreet", Greet.class);
        System.out.println(greet.greeting());
        
        if(ctx.containsBean("eveningGreet")) {
        	EveningGreet greet02 = ctx.getBean("eveningGreet", EveningGreet.class);
        	greet02.doJob();
        }
        
        ((AbstractApplicationContext)ctx).close();
        

    }

}