package com.test05;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.test05.Student.relax(..))")
    public void before() {
        System.out.println("[AOP] 학생용 AOP 적용");
    }
}
