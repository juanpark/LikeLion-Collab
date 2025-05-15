package com.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
    	// singleton (기본): 같은 id bean을 여러번 호출! -> 생성과 소멸관리
    	// prototype (scope 옵션): 하나의 id를 여러개의 getBean()을 이용한 객체로 생성한다. > applicationContext03.xml 옵션 추가
    	// -> 요청할 때마다 새로 생성 -> 생성만 관리 
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext03.xml");
        GreetService svc = ctx.getBean("greetService", GreetService.class);
        GreetService svc02 = ctx.getBean("greetService", GreetService.class);
        // svc.sayHello();
        
        // 1. 객체 참조가 동일한지 확인 
        System.out.println(svc);
        System.out.println(svc02);
        
        // 2. 주소로 확인
        System.out.println(svc == svc02);
        
        // 3. 해시코드로 확인
        System.out.println(System.identityHashCode(svc));
        System.out.println(System.identityHashCode(svc02));
        
    }
}
