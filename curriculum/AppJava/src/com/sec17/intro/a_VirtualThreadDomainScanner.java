package com.sec17.intro;

import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.*;

public class a_VirtualThreadDomainScanner {

    public static void main(String[] args) throws InterruptedException {
        List<String> domains = List.of(
                "www.google.com",
                "www.python.org",
                "openai.com",
                "www.github.com",
                "www.naver.com",
                "nonexistent.abc.def" // 실패 케이스 테스트
        );

        //각 도메인 조회가 독립된 가상 스레드에서 실행
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        System.out.println("도메인 병렬 검사 시작...\n");

        long start = System.currentTimeMillis();

        for (String domain : domains) {
            executor.submit(() -> resolveDomain(domain));
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        long end = System.currentTimeMillis();
        System.out.println("\n전체 완료 시간: " + (end - start) + "ms");
    }

    private static void resolveDomain(String domain) {
        long startTime = System.nanoTime();

        try {
            InetAddress[] addresses = InetAddress.getAllByName(domain);

            synchronized (System.out) {
                System.out.println("[도메인] " + domain);
                for (InetAddress address : addresses) {
                    System.out.println(" → IP: " + address.getHostAddress() + ", 호스트명: " + address.getHostName());
                }
            }

        } catch (Exception e) {
            synchronized (System.out) {
                System.out.println("[도메인] " + domain);
                System.out.println(" → 조회 실패: " + e.getMessage());
            }
        }

        long duration = (System.nanoTime() - startTime) / 1_000_000;
        synchronized (System.out) {
            System.out.println(" 소요 시간: " + duration + "ms");
            System.out.println("----------------------------------");
        }
    }
}
