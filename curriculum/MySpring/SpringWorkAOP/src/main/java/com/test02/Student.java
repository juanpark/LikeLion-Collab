package com.test02;

import org.springframework.stereotype.Component;

@Component
public class Student {
    public String getScore() {
        System.out.println("[Student] 점수 조회 중...");
        return "95점";
    }
}
