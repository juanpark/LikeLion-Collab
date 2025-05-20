package com.test08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Around("execution(* com.test08.Student.study(..))")
    public Object aroundStudy(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[AOP] 수업 준비");  // 실행 전
        Object result = joinPoint.proceed();  // 실제 메서드 실행
        System.out.println("[AOP] 수업 종료");  // 실행 후
        return result;
    }
}
