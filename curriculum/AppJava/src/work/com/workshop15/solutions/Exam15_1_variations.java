package work.com.workshop15.solutions;

// case01: Thread 상속하는 방법 -> 스레드 클래스의 멤버를 상속시 자유롭게 호출 
// 번외 편: 	1. 스레드의 이름을 리턴받자
// 			2. Thread(String name)을 활용해서 스레드 이름을 명시하자
// 			3. 람다로 생성자에게 이름을 전달 해보자
//			4. 생성 후 setName()을 사용해보자
//			5. 가상 스레드 생성해서 이름을 지정해 보자

class MyThreadVar extends Thread {
	
	public MyThreadVar(String name) {
		super(name);	// Thread(string name)
	}
    public void run() {
        System.out.println("스레드 실행 중");
    }
}

public class Exam15_1_variations {
    public static void main(String[] args) {
    	
    	// 3. 람다로 스레드 생성하면서 이름을 전달 해보자.
    	Thread t = new Thread(() -> {
    				System.out.println("hello thread " + Thread.currentThread().getName());
    	}, "my-work01"
    	);
    	
    	t.start();
    	
    	// 4. 생성 후 setName()을 사용해보자.
    	Thread t4 = new Thread(() -> {
    		System.out.println("hello thread04 " + Thread.currentThread().getName());
    	});
    	t4.setName("Thread 04");
    	t4.start();
    	
    	// 5. 가상 스레드를 생성해서 이름을 지정해 보자
    	// ofVirtual java.lang.Tread.Builder.ofVirtual.name(String prefix, long start)
    	// var t05 = ... >>> 아래 Thread로 변경 가능 (리턴 타입이 Thread)
    	Thread t05 = Thread.ofVirtual().name("vt-", 1).unstarted(() -> {	
    		System.out.println("hello virtual thread05 " + Thread.currentThread().getName());
    	} );
    	t05.start();
    	
    	// 6. 위의 경우를 플랫폼 스레드로... 생성 후 실행 .unstarted
    	Thread t06 = Thread.ofPlatform().name("os-", 1).unstarted(() -> {	
    		System.out.println("hello platform thread06 " + Thread.currentThread().getName());
    	} );
    	t06.start();
    	
       	// 7. 위의 경우를 플랫폼 스레드로... 생성과 바로 실행 .start
    	Thread t07 = Thread.ofPlatform().name("os-", 2).start(() -> {	
    		System.out.println("hello platform thread07 " + Thread.currentThread().getName());
    	} );
   
    	
    	
        MyThreadVar t1 = new MyThreadVar("멍멍이");
        MyThreadVar t2 = new MyThreadVar("야옹이");
        t1.start();
        t2.start();
        try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(t1.getName() + " : " + t2.getName());
        System.out.println("main 종료");
    }
}