package work.com.workshop15.solutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam15_5 {
	public static void main(String[] args) throws InterruptedException {
		// ① Virtual Thread용 Executor 생성
		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

		// ② 5개의 Virtual Thread 제출
		for (int i = 1; i <= 5; i++) {
			int num = i;
			executor.submit(() -> {
				try {
					// ③ 스레드 시작 전 0.5초 대기
					Thread.sleep(500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
				// ④ 대기 후 메시지 출력
				System.out.println("가상 스레드 " + num + "번 실행 중");
			});
		}

		// ⑤ Executor 종료 요청
		executor.shutdown();

		// ⑥ 모든 작업이 종료될 때까지 대기
		while (!executor.isTerminated()) {
			Thread.sleep(100);
		}

		// ⑦ 모든 가상 스레드 종료 후 메시지 출력
		System.out.println("main 종료");
	}

}
