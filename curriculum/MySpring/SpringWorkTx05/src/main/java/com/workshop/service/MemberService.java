
package com.workshop.service;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    // 문제1 정답
    public void register(String name, String email) {
        System.out.println("[등록] " + name + " / " + email);
        System.out.println("[메일발송] " + email + "님 환영합니다!");
    }
}
