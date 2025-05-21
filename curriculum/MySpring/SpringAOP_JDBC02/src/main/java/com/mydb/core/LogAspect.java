package com.mydb.core;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Before("execution(* com.mydb.core.EmpService.*(..))")
    public void before(JoinPoint jp) {
        System.out.println("[AOP] Before: " + jp.getSignature().getName());
    }

	@After("execution(* com.mydb.core.EmpService.*(..))")
    public void after(JoinPoint jp) {
        System.out.println("[AOP] After: " + jp.getSignature().getName());
    }
}
