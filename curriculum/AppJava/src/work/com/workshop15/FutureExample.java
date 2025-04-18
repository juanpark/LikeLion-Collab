package work.com.workshop15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureExample {
	public static void main(String[] args) {
		// ① supplyAsync 로 비동기 계산 (200 + 100)
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("비동기 계산 시작");
			return 200 + 100;
		})
		.thenApply(n -> {
			System.out.println("최초 계산 결과:" + n);
			return n;
		})
		// ② 후속 작업: 결과에 2 를 곱함
		.thenApply(n -> n * 2);
		
		// ③ 최종 결과 출력
		try {
			System.out.println("후속 처리 결과 (x2): " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ④ 모든 작업 완료까지 대기
		System.out.println("main 종료");
	}
}

/*
• CompletableFuture.supplyAsync()를 사용하여 두 수를 더하는 계산을 비동기적으로 수행한다.
• 계산된 결과에 후속 작업으로 2를 곱한 결과를 다시 계산한다.
• 마지막으로 결과를 출력한 후, "main 종료" 메시지를 출력한다

출력:
비동기 계산 시작
최초 계산 결과: 300
후속 처리 결과 (x2): 600
main 종료
*/