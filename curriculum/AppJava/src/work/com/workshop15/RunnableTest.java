package work.com.workshop15;

public class RunnableTest {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		
		t1.start();
		t2.start();
		
		/*
		try {
			t1.join(); // 호출한 주체 (메인 스레드)가 t1 스레드 종료까지 대기
			t2.join(); // 호출한 주체 (메인 스레드)가 t2 스레드 종료까지 대기
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("메인 종료");
		*/
	}
}
