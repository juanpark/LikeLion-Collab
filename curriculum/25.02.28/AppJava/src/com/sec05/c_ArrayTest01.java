package com.sec05;

import java.util.Arrays;


// ex) 랜덤 값 생성, 정렬, 출력, 합계 계산을 구현해보자 
public class c_ArrayTest01 {
    public static void main(String[] args) {
        int[] num = new int[5];

        // 배열 초기화 (랜덤 값 할당)
        fillRandomArray(num, 1, 50);

        // 정렬 전 출력
        System.out.println("[정렬 전]");
        printArray(num);

        // 합계 계산
        int sum = sumArray(num);
        System.out.println("\n합=" + sum);

        // 정렬 후 출력
        Arrays.sort(num);
        System.out.println("\n[정렬 후]");
        printArray(num);
    }

    // 배열에 랜덤 값 채우기
    public static void fillRandomArray(int[] array, int min, int max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
    }

    // 배열 출력 (for-each 사용)
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    // 배열 합계 계산
    public static int sumArray(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}
