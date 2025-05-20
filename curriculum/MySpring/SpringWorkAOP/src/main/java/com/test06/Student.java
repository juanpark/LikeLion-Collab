package com.test06;

import org.springframework.stereotype.Component;

@Component

public class Student {
    public int calculate() {
        System.out.println("[Student] 계산 중...");
        return 100;
    }
}
