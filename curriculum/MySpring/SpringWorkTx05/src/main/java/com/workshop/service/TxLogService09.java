package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxLogService09 {

    // 문제9 정답
    @Transactional
    public void doTransaction() {
        System.out.println("[트랜잭션 작업 시작]");
        // DB 작업이 있다고 가정
        System.out.println("[트랜잭션 작업 완료]");
    }
}
