package com.sec16;

import java.util.concurrent.*;

// [Future + Callable] 결과 반환이 있는 비동기 작업
public class j_FutureCallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            Thread.sleep(500);
            return 42;
        };

        Future<Integer> future = executor.submit(task);
        System.out.println("결과 대기 중...");
        Integer result = future.get(); // 결과 대기
        System.out.println("받은 결과: " + result);

        executor.shutdown();
    }
}