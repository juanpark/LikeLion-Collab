package com.workshop;

import com.workshop.service.TxLogService09;

public class Main09 {
    public static void main(String[] args) {
        System.setProperty("org.springframework.transaction", "DEBUG");
        System.out.println(">>> Main09 트랜잭션 로그 확인 실행");
        new TxLogService09().doTransaction();
    }
}
