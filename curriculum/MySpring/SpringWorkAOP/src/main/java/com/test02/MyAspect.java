package com.test02;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	//포인트컷이 정상으로 실행 한 후
    @AfterReturning(pointcut = "execution(* com.test02.Student.getScore(..))", returning = "retVal")
    public void afterReturning(Object retVal) {
        System.out.println("[AOP] 점수 저장 완료");
        System.out.println("리턴값: " + retVal); // ← 필요시 출력 가능
    }
}
