package com.sec16.appletree;

// case 2: Object -> wait(); / notifyAll();
// ThreadPool에서 대기했다가 다시 실행하도록 만든다.
/*
 * 		synchronized(obj) {
 * 			while(!조건) {
 * 				obj.wait(); // 스레드 일시 정지 + 락 반환 *
 * 			}
 *			// 조건이 만족된 후 수행할 작업
 *
 * 		}
 */
public class AppleTreeCase3_WaitNotify extends AppleTreeCompetition {
    private final Object lock = new Object();

    protected boolean pickApple(String who) {
        synchronized (lock) {
            while (apples <= 0) {
                try {
                    lock.wait(); // 대기풀에서 대기번호 들고 기다려 -> 조건이 만족할 때 (notifyAll)까지 스레드 정리
                    System.out.println("DEBUG");
                    return false;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            apples--;
            if (who.equals("Cat")) catCount++;
            else dogCount++;
            System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
            lock.notifyAll(); // 대기풀에 대기번호 받은 스레드는 다시 복귀
        }
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}