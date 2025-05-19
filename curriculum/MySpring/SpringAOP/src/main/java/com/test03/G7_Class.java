package com.test03;

import org.springframework.stereotype.Component;

@Component("g7")
public class G7_Class implements Person {

    // 핵심 코드
    @Override
    public void classWork() {
        System.out.println("[강사] 스레드를 만들어 실습 환경을 구성합니다.");
        System.out.println("[강사] 비대면 스프링 강의를 시작합니다.");
    }
}
