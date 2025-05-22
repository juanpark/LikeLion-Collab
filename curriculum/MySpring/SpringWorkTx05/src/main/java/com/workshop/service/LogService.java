
package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {

    // 문제5 정답
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog(String msg) {
        System.out.println("[로그저장] " + msg);
    }
}
