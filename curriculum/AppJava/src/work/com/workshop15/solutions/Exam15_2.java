package work.com.workshop15.solutions;

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable 실행 중");
    }
}

public class Exam15_2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
    }
}