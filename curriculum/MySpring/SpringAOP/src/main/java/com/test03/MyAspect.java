package com.test03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // 핵심 + 공통 로직을 분리해서 구현하는 클래스
@Component
public class MyAspect  {

    // Advice를 지정함
    @Before("execution(public void com.test03.*.classWork(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("[AOP] 줌인 합니다. 출석 확인.");
    }

    @AfterThrowing(pointcut = "execution(public void com.test03.*.classWork(..))",throwing="e" )
    public void throwing(JoinPoint joinPoint) {
        System.out.println("학습 중 오류가 발생했습니다.");
    }

    @After("execution(public void com.test03.*.classWork(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("[AOP] 줌로그아웃 합니다.");
    }
}
