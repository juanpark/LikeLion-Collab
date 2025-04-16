package com.sec16.appletree;

public abstract class AppleTreeCompetition {
    protected int apples = 1000;
    protected int catCount = 0;
    protected int dogCount = 0;

    public void startCompetition() throws InterruptedException {
        Runnable catTask = () -> {
            while (true) {
                if (!pickApple("Cat")) break;
            }
        };

        Runnable dogTask = () -> {
            while (true) {
                if (!pickApple("Dog")) break;
            }
        };

        Thread t1 = new Thread(catTask);
        Thread t2 = new Thread(dogTask);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("수확 종료!");
        System.out.println("Cat: " + catCount + "개");
        System.out.println("Dog: " + dogCount + "개");
        System.out.println("총 수확 개수: " + (catCount + dogCount));
        System.out.println("남은 사과: " + apples);
    }

    protected abstract boolean pickApple(String who);
}