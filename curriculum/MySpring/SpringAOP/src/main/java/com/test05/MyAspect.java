package com.test05;

import org.aspectj.lang.JoinPoint;

public class MyAspect {

  public void before(JoinPoint joinPoint) {
    System.out.println("[AOP] 메소드 실행 전: " + joinPoint.getSignature().getName());
  }

  public void after(JoinPoint joinPoint) {
    System.out.println("[AOP] 메소드 실행 후: " + joinPoint.getSignature().getName());
  }
}
