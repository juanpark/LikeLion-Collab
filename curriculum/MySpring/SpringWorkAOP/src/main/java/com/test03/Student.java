package com.test03;

import org.springframework.stereotype.Component;

@Component
public class Student {

    public void homework() throws Exception {
        System.out.println("[Student] 과제 수행 중...");
        throw new Exception("파일 오류");  // 강제로 예외 발생
    }
}
