package com.sec12.mstream;

import java.util.Arrays;

public class StreamOperationsTest {
    public static void main(String[] args) {
        // 테스트할 정수 배열 생성
        Integer[] array = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        // 01. filter() 사용 - 짝수만 출력
        System.out.println("== 01. filter() 메소드로 짝수만 출력 ==");
        Arrays.stream(array)
              .filter(value -> value % 2 == 0) // boolean test(int value)
              .forEach(value -> System.out.print(value + " ")); // print void accept(T t)

        // 02. limit() 사용 - 3개의 요소만 출력
        System.out.println("\n== 02. limit() 메소드로 상위 3개 요소만 출력 ==");
        Arrays.stream(array)
              .limit(3)
              .forEach(value -> System.out.println("limitStream : " + value));

        // 03. distinct() 사용 - 중복 요소 제거
        System.out.println("\n== 03. distinct() 메소드로 중복 제거 ==");
        Arrays.stream(array)
              .distinct()
              .forEach(System.out::println);
    }
}
