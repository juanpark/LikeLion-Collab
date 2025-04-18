package work.com.workshop15;

public class SleepThread extends Thread {

	@Override
	public void run() {
		
		try {
			
			for (int i = 1; i <= 5; i++) {
				System.out.println("출력: " + i);
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
}

/*
[문제 4] Thread.sleep()을 사용하여 1초 간격으로 5번 메시지를 출력하세요.
*/