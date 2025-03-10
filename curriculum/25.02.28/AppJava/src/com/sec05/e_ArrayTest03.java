package com.sec05;

public class e_ArrayTest03 {
    public static void main(String[] args) {
        // 2차원 배열 초기화
        int[][] ar = {
            { 10, 10, 10, 10, 0 },
            { 30, 30, 30, 30, 0 },
            { 40, 40, 40, 40, 0 },
            { 50, 50, 50, 50, 0 },
            { 0,  0,  0,  0,  0 } // 합계를 저장할 행/열
        };

        // 초기 배열 출력
        System.out.println("== 초기 배열 ==");
        printArray(ar);

        // 행, 열, 대각선 합 계산
        calculateSums(ar);

        // 계산 후 배열 출력
        System.out.println("== 계산 후 ==");
        printArray(ar);
    }

    // 2차원 배열 출력 메서드
    public static void printArray(int[][] array) {
        for (int[] row : array) {   // 행 반복
            for (int num : row) {   // 열 반복
                System.out.printf("%5d", num);
            }
            System.out.println();   // 줄바꿈
        }
    }

    // 행 합, 열 합, 대각선 합 계산
    public static void calculateSums(int[][] array) {
        int size = array.length - 1; // 마지막 행과 마지막 열은 합계를 저장하는 부분

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][size] += array[i][j];  // 행의 합
                array[size][j] += array[i][j];  // 열의 합
                if (i == j) {
                    array[size][size] += array[i][j];  // 대각선 합
                }
            }
        }
    }
}
