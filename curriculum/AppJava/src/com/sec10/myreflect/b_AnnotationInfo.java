package com.sec10.myreflect;

import java.lang.reflect.Method;

// 클래스를 주면 해당 어노테이션이 있는지 확인 후 해당메서드 실행
public class b_AnnotationInfo {

    public static void main(String[] args) {
        try {
            Class<?> clazz = b_MyClass.class; // 메서드 받았어
            for (Method method : clazz.getDeclaredMethods()) { // 메서드 확인
                if (method.isAnnotationPresent(b_MyAnnotation.class)) { // 해당 어노테이션이 있으면 
                    System.out.println("어노테이션이 적용된 메서드: " + method.getName()); // 메서드 이름을 출력! 
                    method.invoke(clazz.getDeclaredConstructor().newInstance()); // 해당 메서드 실행
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
