
package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TimeoutService {

    // 문제6 정답
    @Transactional(timeout = 2)
    public void slowProcess() throws InterruptedException {
        System.out.println("[슬로우 작업 시작]");
        Thread.sleep(3000);  // 일부러 timeout 유도
        System.out.println("[슬로우 작업 완료]");
    }
}
