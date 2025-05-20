package com.test07;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.test07.Student.homework(..))")
    public void before() {
        System.out.println("[AOP] 작업 시작");
    }
}
