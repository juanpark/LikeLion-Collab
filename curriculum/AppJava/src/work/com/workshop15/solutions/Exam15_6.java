package work.com.workshop15.solutions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exam15_6 {
    public static void main(String[] args) throws InterruptedException {
    	 // ① 비동기 계산 시작 (200 + 100)
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                // ② 0.5초간 연산 대기 시뮬레이션
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return 200 + 100;
        });

        // ③ 결과 출력 (계산 결과: 300)
        try {
			System.out.println("계산 결과: " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // ④ main 종료 메시지
        System.out.println("main 종료");
    }
}