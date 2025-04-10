package com.sec16;

// [7. 동기화 기초] - synchronized 메서드 사용
public class d_SynchronizationBasic {
    public static void main(String[] args) throws InterruptedException {
        final int[] count = {0};

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (count) {
                    count[0]++;
                }
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Final Count: " + count[0]);
    }
}