package com.test06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

  @Pointcut("execution(* com.test06.Student.*(..))")
  public void allMethods(){

  }

  @Before("allMethods()")
  public void before(JoinPoint joinPoint) {
    System.out.println("[AOP] 메소드 실행 전: " + joinPoint.getSignature().getName());
  }

  @After("allMethods()")
  public void after(JoinPoint joinPoint) {
    System.out.println("[AOP] 메소드 실행 후: " + joinPoint.getSignature().getName());
  }

  @AfterReturning(pointcut="allMethods()", returning="retVal")
  public void doAccessCheck(Object retVal){
    System.out.println("@AfterReturning [AOP] 메서드 실행 후: "+retVal);

  }
}
