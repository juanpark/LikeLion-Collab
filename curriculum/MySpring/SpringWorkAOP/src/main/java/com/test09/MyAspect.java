package com.test09;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Around("@annotation(com.test09.LogExecution)")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[AOP] 로깅 처리");
        return joinPoint.proceed();
    }
}
