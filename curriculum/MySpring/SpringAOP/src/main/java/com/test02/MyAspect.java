package com.test02;
import org.aopalliance.intercept.MethodInterceptor; // 메소드 호출을 가로챔
import org.aopalliance.intercept.MethodInvocation; // 실행되는 메소드가 있다면 정보를 담아서 저장하는 객체

//MyAspect는 메소드를 가로 채는 클래스
//MethodInterceptor은 Interceptor 상속. Interceptor은 Advice 상속
public class MyAspect implements MethodInterceptor {

    // invoke(MethodInvocation invocation) -> Advice를 정의하는 곳 = 언제 무슨일을 할지 정의함
    // 언제 : 메소드 호출할 때마다 실행
    // 무슨 일 : 관심사(핵심 공통 분리한 내용)에 대한 로직
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("method "+invocation.getMethod()+"is called on "+
            invocation.getThis()+" with args "+invocation.getArguments());
        Object ret = null;
        System.out.println("[AOP] 줌인 합니다. 출석 확인.");
        try {
           ret = invocation.proceed(); //핵심 메소드 classWork() 실행
        } catch (Exception e) {
            System.out.println("학습 중 오류가 발생했습니다.");
        } finally {
            System.out.println("[학생] 강의종료후 퇴실을 확인합니다.");
        }
        System.out.println("줌로그아웃 합니다.");
        System.out.println("method "+invocation.getMethod()+" return "+ret);
        return ret;
    }
}
