
package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    // 문제3 정답
    @Transactional
    public void outer() {
        System.out.println("[outer 호출]");
        inner();  // 자기 호출로 인해 트랜잭션 적용 안됨 테스트
    }

    public void inner() {
        System.out.println("[inner 호출 → 예외 발생]");
        throw new RuntimeException("예외 발생");
    }
}
