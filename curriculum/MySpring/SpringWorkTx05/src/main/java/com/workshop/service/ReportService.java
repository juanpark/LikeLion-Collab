
package com.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportService {

    @Autowired private AsyncMailService mailService;

    // 문제13 정답
    @Transactional
    public void completeReport() {
        System.out.println("[보고서 저장 완료]");
        mailService.sendAsync();  // 비동기 호출
    }
}
