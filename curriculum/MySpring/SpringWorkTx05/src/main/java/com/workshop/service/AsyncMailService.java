package com.workshop.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncMailService {

    @Async
    public void sendAsync() {
        System.out.println("[비동기 메일 발송]");
    }
}
