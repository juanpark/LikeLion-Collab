package com.sec16;

//  Virtual Threads (JDK 21) - 람다 표현식 사용
public class g_VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 9000; i++) {
            Thread.startVirtualThread(() -> {
                
                try {
                	System.out.println("Virtual Thread: " + Thread.currentThread());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        Thread.sleep(10000); // 메인 스레드가 가상 스레드 종료를 기다림 -> 메인 스레드는 2초간 대기 후 종료 
        // VisualVM 실행 -> Threads 탭 -> 스레드가 실행할 때 일시적으로 Thread 수가 늘었다 줄었다 한다.
    }
}
