package com.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext08.xml");
        
        Runnable task = () -> {
            UserBean bean = ctx.getBean("userBean", UserBean.class);
            UserBean bean1 = ctx.getBean("userBean", UserBean.class);
            
            System.out.println(bean == bean1);
            System.out.println(Thread.currentThread().getName());
        };
        
        Thread t1 = new Thread(task, "Meow");
        Thread t2 = new Thread(task, "Woof");
        
        t1.start();
        t2.start();
        		
    }
}