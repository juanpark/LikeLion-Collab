package com.test06;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @AfterReturning(pointcut = "execution(int com.test06.Student.calculate(..))", returning = "ret")
    public void afterReturningInt(int ret) {
        System.out.println("[AOP] 정수 반환 완료");
        // 필요시 ret 값 출력 가능
        // System.out.println("리턴값: " + ret);
    }
}
