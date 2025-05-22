
package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

class OutOfStockException extends Exception {
    public OutOfStockException(String msg) {
        super(msg);
    }
}

@Service
public class OrderService {

    // 문제4 정답
    @Transactional(rollbackFor = OutOfStockException.class)
    public void orderItem(Long itemId) throws OutOfStockException {
        System.out.println("[주문 시도] 아이템 ID: " + itemId);
        throw new OutOfStockException("재고 부족 예외 발생");
    }
}
