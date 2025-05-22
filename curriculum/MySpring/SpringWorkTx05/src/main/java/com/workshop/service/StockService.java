
package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    // 문제10 정답
    @Transactional
    public void updateStock() {
        System.out.println("[재고 업데이트 실행]");
        // 재시도 처리 예시
    }
}
