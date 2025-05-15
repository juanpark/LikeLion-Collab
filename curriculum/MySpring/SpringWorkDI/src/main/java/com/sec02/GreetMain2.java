package com.sec02;

import org.springframework.context.ApplicationContext;
import com.sec01.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext02.xml");
        Greet greet = ctx.getBean("eveningGreet", Greet.class);
        System.out.println(greet.greeting());
        
        Greet greet02 = ctx.getBean("lunchGreet", Greet.class);
        System.out.println(greet02.greeting());
        
        
        
        ((AbstractApplicationContext)ctx).close();
        

    }

}