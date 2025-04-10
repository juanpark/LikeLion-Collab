package com.sec16;


public class Main3 extends Thread {
    
    public Main3(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i=0; i<5; i++) {
            System.out.println("난 스레드"+getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main3 m1 = new Main3("야옹이");
        Main3 m2 = new Main3("멍멍이");
        m1.setPriority(9);
        System.out.println(m1.getPriority()); // 스레드의 우선순위 확인
        m1.start();
        m2.start();
    }
}