package com.sec16;

// [Deadlock 방지] 락 순서 고정으로 데드락 예방

class SharedResource {
    final String name;

    SharedResource(String name) {
        this.name = name;
    }
}

public class m_DeadlockFreeExample {
    public static void main(String[] args) {
        SharedResource res1 = new SharedResource("🍞");
        SharedResource res2 = new SharedResource("🥛");

        Thread t1 = new Thread(() -> {
            synchronized (res1) {
                System.out.println("🍞 획득 by T1");
                synchronized (res2) {
                    System.out.println("🥛 획득 by T1");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (res1) { // 락 순서 동일
                System.out.println("🍞 획득 by T2");
                synchronized (res2) {
                    System.out.println("🥛 획득 by T2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}