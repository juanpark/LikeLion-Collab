package com.sec16;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

// [ConcurrentHashMap] 스레드 안전한 Map
public class n_ConcurrentMapExample {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> map = new ConcurrentHashMap<>();

        Runnable writer = () -> {
            for (int i = 0; i < 5; i++) {
                map.put(Thread.currentThread().getName() + "-" + i, i);
            }
        };

        Thread t1 = new Thread(writer, "Writer1");
        Thread t2 = new Thread(writer, "Writer2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Map 결과: " + map);
    }
}