package work.com.workshop10.com.elite;
//package com.elite;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CalcSample {
    public int calculate(int data) {
        return IntStream.rangeClosed(1, data) // 1부터 data까지 범위 설정
                .filter(n -> n % 2 == 0) // 짝수 필터링
                .sum(); // 짝수의 합 계산
    }
}

public class Exam01_ClassSample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;

        // 5~10 범위의 숫자를 입력받기 위한 루프
        while (true) {
            System.out.print("정수를 입력하세요 (5~10): ");
            input = scanner.nextInt();
            if (input >= 5 && input <= 10) {
                break;
            }
            System.out.println("잘못된 입력입니다. 5부터 10 사이의 숫자를 입력하세요.");
        }

        // 1부터 입력값까지 숫자 출력
        System.out.println("\n1부터 " + input + "까지의 숫자:");
        IntStream.rangeClosed(1, input)
                 .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 짝수 판별 출력
        System.out.println("\n짝수 판별:");
        IntStream.rangeClosed(1, input)
                 .mapToObj(n -> n + (n % 2 == 0 ? " (짝수)" : " (홀수)"))
                 .forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 짝수 리스트 생성
        List<Integer> evenNumbers = IntStream.rangeClosed(1, input)
                                             .filter(n -> n % 2 == 0)
                                             .boxed() // IntStream → List<Integer>
                                             .collect(Collectors.toList());

        System.out.println("\n입력 값: " + input);
        System.out.println("짝수 리스트: " + evenNumbers);
        System.out.println("짝수 개수: " + evenNumbers.size());

        // 최대값, 최소값 찾기
        int maxEven = evenNumbers.stream().max(Integer::compareTo).orElse(0);
        int minEven = evenNumbers.stream().min(Integer::compareTo).orElse(0);

        System.out.println("짝수 중 가장 큰 값: " + maxEven);
        System.out.println("짝수 중 가장 작은 값: " + minEven);

        // 짝수의 합 계산 (CalcSample 클래스 활용)
        CalcSample calc = new CalcSample();
        int evenSum = calc.calculate(input);

        System.out.println("짝수의 합: " + evenSum);
        
        scanner.close();
    }
}

