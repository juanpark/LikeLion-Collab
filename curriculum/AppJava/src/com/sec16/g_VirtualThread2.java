package com.sec16;

//  Virtual Threads (JDK 21) - 람다 표현식 사용
// 2가지 빌더 테스트를 해보자. 스레드 실행 -> 종료 / 조인도 구현 / 실행시간 체크
public class g_VirtualThread2 {
	public static void main(String[] args) throws InterruptedException {
	    testBuilder(Thread.ofVirtual().name("vt-", 1));
	    testBuilder(Thread.ofPlatform().name("pf-", 1));
	}
	
	public static void testBuilder(Thread.Builder builder) {
		
	}
	
	private static void myjoin(Thread thread) {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}