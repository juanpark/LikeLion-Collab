package work.com.workshop15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncCalcTest {
	public static void main(String[] args) throws InterruptedException {
		// ① 비동기 계산 시작 (200 + 100)
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
		int result = 0;
			// ② 0.5초간 연산 대기
		try {
			Thread.sleep(500);
			result = 200 + 100;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result;
		
		});
		
		// ③ 결과 출력 (계산 결과: 300)
		
		try {
			System.out.println("계산 결과: " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ④ main 종료 메시지
		System.out.println("main 종료");
	}
}

/*
• CompletableFuture.supplyAsync()를 사용하여 숫자 두 개를 더하는 비동기 작업을 수행한다.
• 결과를 받아서 "계산 결과: X" 형태로 출력한다.
• main()에서는 "main 종료"를 마지막에 출력한다
*/