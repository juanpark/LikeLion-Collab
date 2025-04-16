package com.sec16.appletree;

public class AppleTreeCase1_Bug extends AppleTreeCompetition {
    protected boolean pickApple(String who) {
        if (apples <= 0) return false;
        apples--;
        if (who.equals("Cat")) catCount++;
        else dogCount++;
        System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}