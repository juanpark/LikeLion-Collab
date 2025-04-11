package com.sec16;

// Runnable 인터페이스를 이용해서 야옹이, 멍멍이 2개의 스레드를 생성해서 실행 해보자.
// -Runnable 인터페이스를 구현한 클래스를 Thread로 만들어서 start()을 해야 한다.

public class a_exam02 extends Thread {
	
	public a_exam02(String thread_name) {
		super(thread_name); // Thread(String name)
	}
	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			System.out.println("나 스레드야!!! ❤️❤️ => : " + getName() + i);
		}
		
	}
	
	public static void main(String[] args) { // main thread
		// new Thread(new a_exam()).start();
		
		a_exam02 t1 = new a_exam02("야옹이");
		a_exam02 t2 = new a_exam02("멍멍이");
		t1.setPriority(9);
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		t1.start(); // single 1		==> two threads
		t2.start(); // single 1

	}

}
