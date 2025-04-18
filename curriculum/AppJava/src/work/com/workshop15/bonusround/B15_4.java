package work.com.workshop15.bonusround;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class BoundedBuffer02{
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final Object[] items = new Object[5];
    private int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                System.out.println("버퍼 가득 참 - 생산자 대기");
                notFull.await();
            }
            items[putptr] = x;
            putptr = (putptr + 1) % items.length;
            count++;
            System.out.printf("생산 → [%s]  (버퍼 상태: %d/%d)\n", x, count, items.length);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println("버퍼 비어 있음 - 소비자 대기");
                notEmpty.await();
            }
            Object x = items[takeptr];
            takeptr = (takeptr + 1) % items.length;
            count--;
            System.out.printf("소비 ← [%s]  (버퍼 상태: %d/%d)\n", x, count, items.length);
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}

public class B15_4{
    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer02 buffer = new BoundedBuffer02();

        ExecutorService executor = Executors.newFixedThreadPool(2); // 생산자 + 소비자

        Runnable producer = () -> {
            int item = 1;
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    buffer.put(item++);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(" 생산자 인터럽트 종료");
            }
        };

        Runnable consumer = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    buffer.take();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(" 소비자 인터럽트 종료");
            }
        };

        executor.submit(producer);
        executor.submit(consumer);

        // 10초간 실행 후  shutdown
        Thread.sleep(10_000);
        executor.shutdownNow(); // interrupt 전달
        executor.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println(" 프로그램 정상 종료");
    }
}
