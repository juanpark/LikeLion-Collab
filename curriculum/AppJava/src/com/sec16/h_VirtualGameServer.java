package com.sec16;

import java.util.Random;

// [재미 예제] Virtual Thread를 이용한 가상 게임 서버 접속 시뮬레이션
public class h_VirtualGameServer {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("💥 가상 게임 서버 접속 시뮬레이션 시작 💥");

        for (int i = 1; i <= 100; i++) {
            int userId = i;
            Thread.startVirtualThread(() -> {
                String threadName = "User-" + userId;
                System.out.println("🟢 " + threadName + " 접속함");

                try {
                    Thread.sleep(new Random().nextInt(1000)); // 랜덤 딜레이
                    System.out.println("🎮 " + threadName + " 게임 플레이 중...");
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("🔚 " + threadName + " 접속 종료");
            });
        }

        Thread.sleep(3000); // 메인 스레드가 종료되지 않도록 대기
        System.out.println("✅ 모든 가상 유저 시뮬레이션 완료");
    }
}