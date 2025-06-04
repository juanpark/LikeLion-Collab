package com.lab01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* com.sec01..*Controller.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("<=== 진입: " + joinPoint.getSignature().toShortString());
	}
	
	@AfterReturning("execution(* com.sec01..*Controller.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("===> 종료: " + joinPoint.getSignature().toShortString());
	}

}
