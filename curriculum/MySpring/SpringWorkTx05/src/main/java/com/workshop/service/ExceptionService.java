
package com.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class ExceptionService {

    // 문제7 정답
    @Transactional(rollbackFor = IOException.class)
    public void test() throws IOException {
        System.out.println("[IOException 발생]");
        throw new IOException("체크 예외 발생");
    }
}
