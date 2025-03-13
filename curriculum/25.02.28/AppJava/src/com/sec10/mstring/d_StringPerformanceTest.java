package com.sec10.mstring;

public class d_StringPerformanceTest {

	    public static void main(String[] args) {
	        final int ITERATIONS = 100000; 

	        // 1.String 성능 테스트
	        long startTime = System.nanoTime();
	        String str = "";
	        for (int i = 0; i < ITERATIONS; i++) {
	            str += "a"; 
	        }
	        long endTime = System.nanoTime();
	        System.out.println("String 실행 시간: " + (endTime - startTime) / 1_000_000.0 + " ms");

	        
	        // 2. StringBuffer 성능 테스트
	        startTime = System.nanoTime();
	        StringBuffer stringBuffer = new StringBuffer();
	        for (int i = 0; i < ITERATIONS; i++) {
	            stringBuffer.append("a"); // 가변 객체 (성능 향상)
	        }
	        endTime = System.nanoTime();
	        System.out.println("StringBuffer 실행 시간: " + (endTime - startTime) / 1_000_000.0 + " ms");

	        
	        // 3️. StringBuilder 성능 테스트
	        startTime = System.nanoTime();
	        StringBuilder stringBuilder = new StringBuilder();
	        for (int i = 0; i < ITERATIONS; i++) {
	            stringBuilder.append("a"); // 가변 객체 (StringBuffer보다 빠름)
	        }
	        endTime = System.nanoTime();
	        System.out.println("StringBuilder 실행 시간: " + (endTime - startTime) / 1_000_000.0 + " ms");
	    }
	}
