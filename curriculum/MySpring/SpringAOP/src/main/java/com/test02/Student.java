package com.test02;

public class Student implements Person {

    //핵심 코드
    @Override
    public void classWork() {
        System.out.println("[학생] 큐알입실 완료, 수업 참여 중입니다.");
        System.out.println("[학생] 집중하여 학습합니다.");
    }
}
