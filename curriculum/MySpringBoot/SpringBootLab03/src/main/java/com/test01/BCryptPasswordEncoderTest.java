package com.test01;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptPasswordEncoderTest {

    public static void main(String[] args) {
        // 1. 평문 비밀번호
        // String rawPassword = "testpass";
    	Scanner sc = new Scanner(System.in);
    	String rawPassword = sc.next();

        // 2. BCryptPasswordEncoder 객체 생성
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 3. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("암호화된 비밀번호: " + encodedPassword);

        // 4. 검증
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println("비밀번호 매칭 결과: " + matches);

        // 5. 새로운 비밀번호 비교
        String otherPassword = "otherpass";
        boolean otherMatches = passwordEncoder.matches(otherPassword, encodedPassword);
        System.out.println("다른 비밀번호 매칭 결과: " + otherMatches);
    }
}
