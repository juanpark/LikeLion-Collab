package work.com.workshop15.solutions;

import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void safeAccess() {
        lock.lock();
        try {
            System.out.println("잠금 획득");
        } finally {
            System.out.println("잠금 해제");
            lock.unlock();
        }
    }
}

public class Exam15_9 {
    public static void main(String[] args) {
    	  // ① 공유 자원 객체 생성
        SharedResource res = new SharedResource();

        // ② 두 개의 스레드 정의 및 실행
        Thread t1 = new Thread(res::safeAccess);
        Thread t2 = new Thread(res::safeAccess);

        // ③ 스레드 실행
        t1.start();
        t2.start();
    }
}