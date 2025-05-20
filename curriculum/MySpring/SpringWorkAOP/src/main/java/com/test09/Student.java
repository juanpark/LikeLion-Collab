package com.test09;

import org.springframework.stereotype.Component;

@Component
public class Student {

    @LogExecution
    public void submit() {
        System.out.println("[Student] 제출 중...");
    }
}
