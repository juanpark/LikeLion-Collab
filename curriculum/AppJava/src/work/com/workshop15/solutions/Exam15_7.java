package work.com.workshop15.solutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam15_7 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) {
            final int taskNum = i;
            pool.execute(() -> System.out.println("작업 " + taskNum + " 처리 중"));
        }
        pool.shutdown();
    }
}