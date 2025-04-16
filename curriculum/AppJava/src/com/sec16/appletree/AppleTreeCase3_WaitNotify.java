package com.sec16.appletree;

public class AppleTreeCase3_WaitNotify extends AppleTreeCompetition {
    private final Object lock = new Object();

    protected boolean pickApple(String who) {
        synchronized (lock) {
            while (apples <= 0) {
                try {
                    lock.wait();
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
            lock.notifyAll();
        }
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}