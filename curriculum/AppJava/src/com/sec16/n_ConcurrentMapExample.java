package com.sec16;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

// [ConcurrentHashMap] 스레드 안전한 Map
public class n_ConcurrentMapExample {
    public static void main(String[] args) throws InterruptedException {
    	
    	// 실시간 로그 데이터 생성 / 데이터 집계
        Map<String, Integer> map = new ConcurrentHashMap<>(); // ThreadGroup -> 부모와 자식 O / ConcurrentHashMap 팀, 조원

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