package com.sec10.mstring;

public class a_StringBufferTest {
    public static void main(String[] args) {
        // 1. StringBuffer 객체 생성
        StringBuffer sb = new StringBuffer("Hello");

        // 2️. append(): 문자열 추가
        sb.append(" Java");
        System.out.println("append 후: " + sb); // Hello Java

        // 3️. insert(): 특정 위치에 문자열 삽입
        sb.insert(6, "World ");
        System.out.println("insert 후: " + sb); // Hello World Java

        // 4️. replace(): 특정 범위를 다른 문자열로 변경
        sb.replace(6, 11, "Amazing");
        System.out.println("replace 후: " + sb); // Hello Amazing Java

        // 5️. delete(): 특정 범위 삭제
        sb.delete(6, 13);
        System.out.println("delete 후: " + sb); // Hello Java

        // 6️.reverse(): 문자열 뒤집기
        sb.reverse();
        System.out.println("reverse 후: " + sb); // avaJ olleH

        // 7️. length()와 capacity() 확인
        System.out.println("문자열 길이: " + sb.length()); // 10
        System.out.println("버퍼 크기: " + sb.capacity()); // 기본 용량(16) + 초기 문자열 길이
    }
}
