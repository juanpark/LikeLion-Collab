package com.test01;

import org.springframework.stereotype.Component;

@Component
public class Student {
    public void study() {
        System.out.println("[Student] 공부하는 중입니다.");
    }
}
