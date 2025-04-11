package com.sec16;

// [7. 동기화 기초] - synchronized 메서드 사용
public class d_SynchronizationBasic {
    public static void main(String[] args) throws InterruptedException {
    // 람다식에서 외부 변수를 참조할 때 final이어야 한다.
    	
    	final int[] count = {0}; // 배열 상수 : 배열은 참조값이 변하지 않는다.

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) { // 하나의 스레드만 접근 가능하도록 만들어 준다
                synchronized (count) {
                    count[0]++;
                }
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();
        
        // 만일 조인을 주지 않으면 메인스레드가 thread1, thread2가 끝나기 전에 출력을 실행하다. 
        thread1.join();	// 스레드가 종료할 때까지 기다린다.
        thread2.join(); // 스레드가 종료할 때까지 기다린다.

        System.out.println("Final Count: " + count[0]);
        
        // 실행결과 테스트
        // 1. synchronized O, join O	-> Final Count : 2000 
        // 2. synchronized X, join O	-> Final Count : 2000 보다 낮게 나온다
        // 3. synchronized O, join X	-> Final Count : 0, 1000, 1500 등이 랜덥으로 나온다 (스레드 종료 시점)
        // 멀티스레드는 항상 synchronized(공유자원 LOCK), join(대기)을 고려해서 프로그램을 작성해야 한다.
        
    }
}