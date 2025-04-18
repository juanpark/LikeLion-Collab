package work.com.workshop15.solutions;

class CounterV {
    private int count = 0;
    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}

public class Exam15_3_variations {
    public static void main(String[] args) throws InterruptedException {
        CounterV counter = new CounterV();

        Runnable task = () -> {
            for (int i = 0; i < 500; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

        System.out.println("최종 카운터 값: " + counter.getCount());
    }
}