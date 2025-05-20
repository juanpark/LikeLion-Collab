package com.test03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @AfterThrowing(pointcut = "execution(* com.test03.Student.homework(..))", throwing = "e")
    public void handleException(JoinPoint joinPoint, Throwable e) {
        System.out.println("[AOP] 과제 오류 발생: " + e.getMessage());
    }
}
