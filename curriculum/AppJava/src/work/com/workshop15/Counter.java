package work.com.workshop15;

public class Counter {

	private int counter;
	
	public synchronized void increment() {
		counter++;
	}
	
	public int getCount() {
		return counter;
	}
}

/*
increment() : void			공유 자원 증가,
getCount():int 				synchronized 사용
*/