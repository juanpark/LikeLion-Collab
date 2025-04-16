package com.sec16.appletree;

import java.util.concurrent.CompletableFuture;

public class AppleTreeCase4_Async extends AppleTreeCompetition {
    protected boolean pickApple(String who) {
        CompletableFuture.runAsync(() -> {
            synchronized (this) {
                if (apples <= 0) return;
                apples--;
                if (who.equals("Cat")) catCount++;
                else dogCount++;
                System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
            }
        });
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}