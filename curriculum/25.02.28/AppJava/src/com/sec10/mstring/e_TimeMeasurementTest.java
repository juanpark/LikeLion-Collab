package com.sec10.mstring;

public class e_TimeMeasurementTest {

	public static void main(String[] args) {
		long startTime = System.nanoTime(); 

        long sum = 0;
        for (int i = 1; i <= 100000; i++) {
            sum += i;
        }

        long endTime = System.nanoTime(); 

        // 실행 시간 출력 (나노초 → 밀리초 변환)
        System.out.println("실행 시간: " + (endTime - startTime) / 1_000_000.0 + " ms");

	}

}
