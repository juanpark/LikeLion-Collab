package com.sec16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// [ExecutorService] 고정 크기 스레드 풀로 작업 실행
public class i_ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // 3개 스레드 풀

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // 작업 제출 종료
    }
}