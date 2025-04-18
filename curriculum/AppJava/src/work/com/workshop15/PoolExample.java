package work.com.workshop15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolExample {

	public static void main(String[] args) {
		// Executors.newFixedThreadPool(3)를 사용하여 스레드 수가 3개인 고정 스레드풀(FixedThreadPool)을 생성한다.
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		
		// 총 5개의 작업을 스레드 풀에 등록하여 실행한다.
		// 각 작업은 "작업 X 처리 중"이라는 메시지를 출력한다. (X는 작업 번호)
		for (int i = 1; i <= 5; i++) {
			final int taskNum = i;
			
			executor.submit(() -> {
				System.out.println("작업 " + taskNum + " 처리 중");
			});
		}
		
		// shutdown()을 호출하여 더 이상 작업을 추가할 수 없도록 종료 처리한다
		executor.shutdown();
	}

}


