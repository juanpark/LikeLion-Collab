package com.sec16;

// [5. 스레드 상태], [6. 스레드 제어 메서드]
public class f_ThreadStateDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("Thread started. State: " + Thread.currentThread().getState());
            try {
                Thread.sleep(1000); // TIMED_WAITING 상태
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("Before start: " + t.getState()); // NEW
        t.setName("DemoThread");
        t.start();

        // 실행 중 상태 확인
        while (t.isAlive()) {
            System.out.println(t.getName() + " is alive. State: " + t.getState());
            Thread.sleep(200);
        }

        System.out.println("After finish: " + t.getState()); // TERMINATED
        System.out.println("Main Thread: " + Thread.currentThread().getName());
    }
}