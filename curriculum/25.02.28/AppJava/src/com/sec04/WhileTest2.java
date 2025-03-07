package com.sec04;

public class WhileTest2 {
	
	public static void test01() {
		int i = 1;
		System.out.println("Countdown start!");

		while (i <= 5) {
			System.out.printf("%5d", i);
			i++;
		}// while end
		System.out.println(" end i = " + i);
	}
	
	private static void test02() {
		int i = 1;		// 지역변수 초기화
		while (i <= 5) {			// 1 <= 5 참, 	2 <= 5 참,	3 <= 5 참,	4 <= 5 참,	5 <= 5참,	6 <= 5 거짓 (종료) 
		    // System.out.println(i);	// 1,			2,			3,			4,			5 (출력)
		    i++;					// 2,			3,			4,			5,			6
			System.out.println(i);	// 2,			3,			4,			5,			6 (출력)
		}
		
	}
	
	public static void main(String[] args) {
		test01();
		System.out.printf("\n======================================\n");
		test02();

	}// main end



}// WhileTest end

