package com.sec16;

import java.util.concurrent.atomic.AtomicInteger;

// 동기화 기초 - synchronized 메서드 사용
public class e_SynchronizationBasic {
    public static void main(String[] args) throws InterruptedException {
    	// final int[] count = {0};
    	// 동기화 정수를 호출
    	AtomicInteger count = new AtomicInteger(0);

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                    count.incrementAndGet();
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Final Count: " + count.get());
    }
}