package com.test04;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.test04.Student.eat(..))")
    public void before() {
        System.out.println("[AOP] 먹을 준비 완료: 라면");
    }
}
