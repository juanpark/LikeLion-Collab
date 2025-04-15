package com.sec16;

// Virtual Threads (JDK 21) - 람다 표현식 사용
// 2가지 빌더 테스트를 해보자. 스레드 실행 -> 종료 / 조인도 구현 
// 실행시간 체크 -> 0.5초 동안 sleep을 두고 작업 시뮬레이션을 해보자. 

public class g_VirtualThread3 {
    public static void main(String[] args) throws InterruptedException {
        testBuilder(Thread.ofVirtual().name("vt-", 1));
        testBuilder(Thread.ofPlatform().name("pf-", 1));
    }

    public static void testBuilder(Thread.Builder builder) {
        System.out.println("\n[ TEST ] 실행 대상 " + builder.getClass().getSimpleName());
        long start = System.currentTimeMillis();

        switch (builder) {
            case Thread.Builder.OfVirtual v -> {
                System.out.println("가상 스레드 생성");
                Thread thread = v.start(() -> {
                    System.out.println("실행 중 (Virtual) " + Thread.currentThread());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException i) {
                        i.printStackTrace();
                    }
                });
                myjoin(thread);
            }

            case Thread.Builder.OfPlatform p -> {
                System.out.println("플랫폼 스레드 생성");
                Thread thread = p.start(() -> {
                    System.out.println("실행 중 (Platform) " + Thread.currentThread());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException i) {
                        i.printStackTrace();
                    }
                });
                myjoin(thread);
            }
        }

        long duration = System.currentTimeMillis() - start;
        System.out.println("실행시간 " + duration + "ms");
    }

    public static void myjoin(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
    }
}