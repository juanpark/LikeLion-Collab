package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


public class MyAspect  {

    // Advice를 지정함
    public void before(JoinPoint joinPoint) {
        System.out.println("[AOP] 줌인 합니다. 출석 확인.");
    }

    public void throwing(JoinPoint joinPoint) {
        System.out.println("학습 중 오류가 발생했습니다.");
    }


    public void after(JoinPoint joinPoint) {
        System.out.println("[AOP] 줌로그아웃 합니다.");
    }
}
