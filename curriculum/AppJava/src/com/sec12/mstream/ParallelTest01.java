package com.sec12.mstream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
//직렬 처리(Sequential Processing)와 병렬 처리(Parallel Processing)를 비교해보자. 


public class ParallelTest01 {

    public static void main(String[] args) {
        // 리스트 초기화
        List<BigDecimal> list = createBigDecimalList();

        //  직렬 처리 실행
        long start = System.currentTimeMillis();
        BigDecimal sequentialResult = processSequential(list);
        long end = System.currentTimeMillis();
        System.out.println("=======> 직렬 처리 시간: " + (end - start) + "ms");

        //  병렬 처리 실행
        start = System.currentTimeMillis();
        BigDecimal parallelResult = processParallel(list);
        end = System.currentTimeMillis();
        System.out.println("==========> 병렬 처리 시간: " + (end - start) + "ms");
    }

    /**
     * BigDecimal 리스트 생성
     */
    private static List<BigDecimal> createBigDecimalList() {
        List<BigDecimal> list = new ArrayList<>();
        list.add(new BigDecimal("1"));
        list.add(new BigDecimal("2"));
        list.add(new BigDecimal("3"));
        list.add(new BigDecimal("4"));
        list.add(new BigDecimal("5"));
        return list;
    }

    /**
     * 직렬(Sequential) 스트림 처리
     */
    private static BigDecimal processSequential(List<BigDecimal> list) {
        System.out.println("--- 직렬 처리 (Sequential Processing) ---");
        return list.stream().reduce(new BigDecimal("100"), (value1, value2) -> {
            printValues(value1, value2);
            return value1.add(value2);
        });
    }

    /**
     * 병렬(Parallel) 스트림 처리
     */
    private static BigDecimal processParallel(List<BigDecimal> list) {
        System.out.println("\n--- 병렬 처리 (Parallel Processing) ---");
        return list.parallelStream().reduce(new BigDecimal("100"), (value1, value2) -> {
            printValues(value1, value2);
            return value1.add(value2);
        });
    }

    /**
     * 연산 과정 출력
     */
    private static void printValues(BigDecimal value1, BigDecimal value2) {
        System.out.println("value1 = " + value1);
        System.out.println("value2 = " + value2);
    }
}