package com.sec16;

public class ThreadBuilderPractice {
    public static void main(String[] args) throws InterruptedException {
        testBuilder(Thread.ofVirtual().name("v-", 1));
        testBuilder(Thread.ofPlatform().name("p-", 1));
    }

    public static void testBuilder(Thread.Builder builder) throws InterruptedException {
        System.out.println("▶ Thread.Builder 타입: " + builder.getClass().getSimpleName());

        switch (builder) {
            case Thread.Builder.OfVirtual v -> {
                System.out.println("▶ 가상 스레드 실행");
                Thread t = v.start(() -> {
                    System.out.println("실행 중 (Virtual): " + Thread.currentThread());
                });
                t.join();
            }
            case Thread.Builder.OfPlatform p -> {
                System.out.println("▶ 플랫폼 스레드 실행");
                Thread t = p.start(() -> {
                    System.out.println("실행 중 (Platform): " + Thread.currentThread());
                });
                t.join();
            }
        }
    }
}

