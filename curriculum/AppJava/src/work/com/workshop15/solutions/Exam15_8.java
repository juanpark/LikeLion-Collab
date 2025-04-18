package work.com.workshop15.solutions;


class Buffer {
	private int data;
	private boolean hasData = false;

	public synchronized void produce(int value) {
		while (hasData) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		data = value;
		hasData = true;
		System.out.println("생산됨: " + data);
		notify();
	}

	public synchronized void consume() {
		while (!hasData) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("소비됨: " + data);
		hasData = false;
		notify();
	}
}

public class Exam15_8 {
	public static void main(String[] args) {
		// ① 공유 자원 생성
		Buffer buffer = new Buffer();

		// ② 생산자 스레드 정의
		Thread producer = new Thread(() -> {
			for (int i = 1; i <= 5; i++)
				buffer.produce(i);
		});

		// ③ 소비자 스레드 정의
		Thread consumer = new Thread(() -> {
			for (int i = 1; i <= 5; i++)
				buffer.consume();
		});

		// ④ 스레드 시작
		producer.start();
		consumer.start();
	}

}
