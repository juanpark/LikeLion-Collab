package com.test01;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Before("execution(* com.test01.Student.study(..))")
    public void before() {
        System.out.println("[AOP] 공부 시작합니다.");
    }
}
