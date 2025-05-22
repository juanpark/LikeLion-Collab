
package com.workshop.service;

import org.springframework.stereotype.Service;
import com.workshop.vo.Order;

@Service
public class PaymentService {

    // 문제15 정답
    public void processPayment(Order order) {
        try {
            System.out.println("[외부 결제 처리 중...]");
            throw new RuntimeException("결제 실패");
        } catch (Exception e) {
            System.out.println("[예외 발생 → 무시하고 DB 저장 진행]");
        }
        System.out.println("[DB 저장 완료]");
    }
}
