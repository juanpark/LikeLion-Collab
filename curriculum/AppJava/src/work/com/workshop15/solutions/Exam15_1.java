package work.com.workshop15.solutions;

class MyThread extends Thread {
    public void run() {
        System.out.println("스레드 실행 중");
    }
}

public class Exam15_1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
        System.out.println("main 종료");
    }
}