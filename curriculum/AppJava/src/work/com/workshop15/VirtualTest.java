package work.com.workshop15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualTest {

	public static void main(String[] args) throws InterruptedException {
		// ① Virtual Thread 용 Executor 생성
		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
		
		// ② 5 개의 Virtual Thread 제출
		for (int i = 1; i <= 5; i++) {
			final int taskNum = i;
			Runnable task = () -> {
				try {
					// ③ 스레드 시작 전 0.5 초 대기
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// ④ 대기 후 메시지 출력
				System.out.println("가상 스레드 " + taskNum + "번 실행 중");
			};
			executor.submit(task);
		}
		// ⑤ Executor 종료 요청
		executor.shutdown();
		
		
		// ⑥ 모든 작업이 종료될 때까지 대기
		if(executor.awaitTermination(3, TimeUnit.SECONDS)) {
		
			// ⑦ 모든 가상 스레드 종료 후 메시지 출력
			System.out.println("main 종료");
		} else {
			System.out.println("스레드 타임 아웃");
		}
		
	}
}

/*
• Thread.ofVirtual().start(...) 또는
Executors.newVirtualThreadPerTaskExecutor()를 사용하여 가상 스레드를 여러 개
동시에 실행한다
• 각 가상 스레드는 0.5초씩 sleep한 후 "가상 스레드 X번 실행 중" 메시지를 출력한다
• main 스레드는 "main 종료" 메시지를 마지막에 출력하도록 한다.
*/