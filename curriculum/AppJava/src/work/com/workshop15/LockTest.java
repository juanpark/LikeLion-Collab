package work.com.workshop15;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
	private final ReentrantLock lock = new ReentrantLock();
	
	public void safeAccess() {
		lock.lock();
		try {
			System.out.println("잠금획득");
		} finally {
			lock.unlock();
			System.out.println("잠금해제");
		}
	}
}
	
		
		
public class LockTest {	
	
	public static void main(String[] args) {
		// ① 공유 자원 객체 생성
		SharedResource res = new SharedResource();
		
		// ② 두 개의 스레드 정의 및 실행
		Thread t1 = new Thread(res::safeAccess);
		Thread t2 = new Thread(res::safeAccess);
		
		// ③ 스레드 실행
		t1.start();
		t2.start();
	}
}

/*
• ReentrantLock 클래스를 사용하여 스레드 간 락 기반 동기화를 구현한다.
• safeAccess() 메서드에서는 락을 획득하고 "잠금 획득" 메시지를 출력한 뒤, 종료 시
반드시 "잠금 해제" 메시지를 출력한다.
• main 메서드에서는 두 개의 스레드를 생성하여 safeAccess() 메서드에 동시에
접근하도록 한다.

출력:
잠금 획득
잠금 해제
잠금 획득
잠금 해제
*/