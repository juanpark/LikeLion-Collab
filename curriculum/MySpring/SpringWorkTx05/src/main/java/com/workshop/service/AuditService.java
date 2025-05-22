
package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.workshop.vo.AuditLog;

@Service
public class AuditService {

    // 문제12 정답
    @Transactional(transactionManager = "auditTxManager")
    public void saveAudit(AuditLog log) {
        System.out.println("[감사 로그 저장] " + log.getMessage());
    }
}
