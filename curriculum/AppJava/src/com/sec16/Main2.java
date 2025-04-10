package com.sec16;

public class Main2 extends Thread {
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("난 스레드");
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main2 m1 = new Main2();
        Main2 m2 = new Main2();
        m1.start();
        m2.start();
    }
}
