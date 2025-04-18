package work.com.workshop15.solutions;

import java.util.concurrent.CompletableFuture;

public class Exam15_10 {
    public static void main(String[] args) {
        System.out.println("비동기 계산 시작");

        // ① supplyAsync로 비동기 계산 (200 + 100)
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500); // 계산 대기 시뮬레이션
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return 200 + 100;
        });

        // ② 후속 작업: 결과에 2를 곱함
        CompletableFuture<Integer> result = future.thenApply(sum -> {
            System.out.println("최초 계산 결과: " + sum);
            return sum * 2;
        });

        // ③ 최종 결과 출력
        result.thenAccept(multiplied -> {
            System.out.println("후속 처리 결과 (x2): " + multiplied);
        });

        // ④ 모든 작업 완료까지 대기
        result.join();
        System.out.println("main 종료");
    }
}
