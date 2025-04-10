package com.sec16;

// [추가 예제] ThreadGroup 사용 예제
public class g_ThreadGroupDemo {
    public static void main(String[] args) {
        // 1. 스레드 그룹 생성
        ThreadGroup group = new ThreadGroup("MyThreadGroup");

        // 2. Runnable 정의
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            ThreadGroup tg = Thread.currentThread().getThreadGroup();
            for (int i = 0; i < 3; i++) {
                System.out.println("[" + tg.getName() + "] " + name + " - " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // 3. 그룹에 속한 스레드 생성
        Thread t1 = new Thread(group, task, "Thread-A");
        Thread t2 = new Thread(group, task, "Thread-B");

        // 4. 실행
        t1.start();
        t2.start();

        // 5. 그룹 정보 출력
        System.out.println("활성 스레드 수: " + group.activeCount());
        group.list();
    }
}