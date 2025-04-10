package com.sec16;

public class Main implements Runnable {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Thread(new Main()).start();
        Thread t1 = new Thread(new Main(), "야옹이");
        Thread t2 = new Thread(new Main(), "멍멍이");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("난 스레드야");
    }
}
