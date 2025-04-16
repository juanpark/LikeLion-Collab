package com.sec16.appletree;

import java.util.concurrent.locks.*;

public class AppleTreeCase5_AwaitSignal extends AppleTreeCompetition {
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();

    protected boolean pickApple(String who) {
        lock.lock();
        try {
            while (apples <= 0) {
                try {
                    notEmpty.await();
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
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}