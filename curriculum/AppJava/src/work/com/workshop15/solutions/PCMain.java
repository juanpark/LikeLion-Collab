package work.com.workshop15.solutions;

public class Buffer {
	
	private int[] bufferArray;
	
	public Buffer() {}

	public synchronized void produce() {
		System.out.println("생산됨: " + i);
	}
	
	public synchronized void consume() {
		System.out.println("소비됨: " + i);
	}
	
	
}

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

/*
• Buffer 클래스를 생성하여 하나의 데이터를 저장할 수 있는 공유 자원을 구현한다.
• synchronized, wait(), notify()를 사용하여
생산자(Producer)와 소비자(Consumer) 간의 데이터 충돌 없이 순차 처리를 구현한다.
• 생산자는 1부터 5까지 숫자를 차례대로 저장하고, 소비자는 저장된 데이터를 차례대로 꺼내
출력한다
• 항상 "생산됨 → 소비됨" 순으로 나타나야 하며, 순서가 바뀌면 동기화 실패이다.

출력 예:
생산됨: 1
소비됨: 1
…
..
생산됨: 5
소비됨: 5
*/
