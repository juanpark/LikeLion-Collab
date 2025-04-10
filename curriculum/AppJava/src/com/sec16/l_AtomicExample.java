package com.sec16;

import java.util.concurrent.atomic.AtomicInteger;

// [AtomicInteger] 스레드 안전한 카운터
public class l_AtomicExample {
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet(); // 원자적 증가
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("최종 카운트: " + counter.get());
    }
}