package com.sec16;

// [8. Virtual Threads (JDK 21)] - 람다 표현식 사용
public class e_VirtualThreadExample {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.startVirtualThread(() -> {
                System.out.println("Virtual Thread: " + Thread.currentThread());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        Thread.sleep(2000); // 메인 스레드가 가상 스레드 종료를 기다림
    }
}