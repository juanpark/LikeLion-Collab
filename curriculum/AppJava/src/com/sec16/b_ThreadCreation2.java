package com.sec16;

// [4. 스레드 생성 방법]
// case02: Runnable 구현 - Thread 생성자에 Runnable 전달

class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class b_ThreadCreation2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable("Runnable-A"));
        Thread thread2 = new Thread(new MyRunnable("Runnable-B"));
        thread1.start();
        thread2.start();
    }
}