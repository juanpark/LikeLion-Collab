package com.sec10.myreflect;

import java.lang.reflect.Method;

public class b_AnnotationInfo {

    public static void main(String[] args) {
        try {
            Class<?> clazz = MyClass.class;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(MyAnnotation.class)) {
                    System.out.println("어노테이션이 적용된 메서드: " + method.getName());
                    method.invoke(clazz.getDeclaredConstructor().newInstance()); // 메서드 실행
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
