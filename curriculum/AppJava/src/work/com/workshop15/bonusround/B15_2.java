package work.com.workshop15.bonusround;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class B15_2 {
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

		// 최대 3초 동안 모든 작업이 종료 되기를 기다리자
		if(executor.awaitTermination(3, TimeUnit.SECONDS)) {	
			System.out.println("모든 작업 종료");
		} else {
			System.out.println("종료 안된 작업 있음");
		}
		
		// ⑦ 모든 가상 스레드 종료 후 메시지 출력
		System.out.println("main 종료");	
	}
}

/*
 *  shutdown()		: 새로운 스레드 상관없이 기존 작업을 마무리
 *  shutdownNow()	: 지금 모든 작업 중단 (interrupt)
 * 	isTerminated()	: 위 두개의 메소드가 호출되면 모든 작업이 끝났는지 true로 확인
 * 	awaitTermination(long timeout, TimeUnit unit) : 일정 시간 대기 하면서 종료를 기다린다
 * 
 * 	shutdown() 호출한다고 해서 작업이 끝난게 아님. isTerminated()로 확인한다
 */