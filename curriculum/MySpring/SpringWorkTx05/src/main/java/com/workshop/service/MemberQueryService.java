
package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberQueryService {

    // 문제2 정답
    @Transactional(readOnly = true)
    public void getMemberById(Long id) {
        System.out.println("[조회] 회원 ID: " + id);
    }
}
