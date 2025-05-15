package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext01.xml");
        // 구체 클래스를 bean으로 등록하고 getBean()을 사용해서 선조 인터페이스를 리턴한다. 
        // 1. 메모리 로드된 객체를 찾아서 리턴확인
        Greet greet = (Greet) ctx.getBean("morningGreet");
        System.out.println(greet.greeting());
        
        // 2. 현재 메인영역에서 작업하는 ctx 확인 
        System.out.println("== main ==");
        System.out.println(ctx.toString());
        System.out.println(ctx.getDisplayName());
        
        
        // 3. ctx 명시 소멸
        // ((AbstractApplicationContext) ctx).close();
        /*
        if(ctx instanceof ConfigurableApplicationContext) {
        	((ConfigurableApplicationContext) ctx).close();
        }
        */
        
        // 4. ctx close됨을 확인
        if(ctx instanceof ConfigurableApplicationContext) {
        	boolean isActive = ((ConfigurableApplicationContext) ctx).isActive();
        	System.out.println(isActive);
        }
        
        // 5. getBean()으로 재확인
        try {
	        greet = ctx.getBean("morningGreet", Greet.class);
	        System.out.println(greet.greeting());
        } catch (IllegalStateException i) {
        	System.out.println("BeanFactory not initialized or already closed");
        }
    }
}