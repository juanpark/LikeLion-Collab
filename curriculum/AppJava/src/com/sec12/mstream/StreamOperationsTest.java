package com.sec12.mstream;

import java.util.Arrays;

public class StreamOperationsTest {
    public static void main(String[] args) {
        // 테스트할 정수 배열 생성
        Integer[] array = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}; //Integer - 참조형타입만 사용

        // 01. filter() 사용 - 짝수만 출력
        System.out.println("== 01. filter() 메소드로 짝수만 출력 ==");
        Arrays.stream(array) // 스트림 생성
              .filter(value -> value % 2 == 0) // 짝수만 필터링 boolean test(int value)  -> 값 하나씩 넣어서 false,true판별 후 true만 모음
              .forEach(System.out::println); //출력      컨슈머객체  void accept(T t)

        // 02. limit() 사용 - 3개의 요소만 출력
        System.out.println("\n== 02. limit() 메소드로 상위 3개 요소만 출력 ==");
        Arrays.stream(array)
              .limit(3)
              .forEach(e -> System.out.println("limitStream : " + e));
        
        // 02-2. limit() 사용 - 3개의 요소만 출력
        System.out.println("\n== 02. limit() 메소드로 상위 3개 요소만 출력 ==");
        Arrays.stream(array)
              .limit(3)
              .forEach(e -> System.out.printf("limitStream : %5d", e));

        // 03. distinct() 사용 - 중복 요소 제거
        System.out.println("\n== 03. distinct() 메소드로 중복 제거 ==");
        Arrays.stream(array)
              .distinct()
              .forEach(System.out::println);
    }
}
