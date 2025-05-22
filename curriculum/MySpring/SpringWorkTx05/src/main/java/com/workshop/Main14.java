package com.workshop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // 트랜잭션보다 먼저 실행
class LoggingAspect14 {
    @Before("execution(* com.workshop.service..*(..))")
    public void logStart() {
        System.out.println("메서드 시작 로그 - LoggingAspect14");
    }
}

public class Main14 {
    public static void main(String[] args) {
        System.out.println(">>> Main14 AOP 순서 제어 실행");
    }
}