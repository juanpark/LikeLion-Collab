package work.com.workshop15;

public class ThreadTest {
	public static void main(String[] args) {
		
		MyThread mt1 = new MyThread();
		MyThread mt2 = new MyThread();
		
		mt1.start();
		mt2.start();
		
		try {
			mt1.join(); // 호출한 주체 (메인 스레드)가 mt1 스레드 종료까지 대기
			mt2.join(); // 호출한 주체 (메인 스레드)가 mt2 스레드 종료까지 대기
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("메인 종료");
		
	}
}

/*
Thread 클래스를 상속한 클래스를 정의하고, run() 메서드에서 "스레드 실행중"을 출력하도록 하세요.
main 메서드에서 두 개의 스레드를 생성하고 실행한 뒤, "main 종료" 메시지를 출력하세요.
*/
