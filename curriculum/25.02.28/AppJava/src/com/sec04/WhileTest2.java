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
	
	/*
	 * 1 ~ 100까지 숫자를 출력해보자 while로 작성하자 
	 * 조건 1 : 짝수만 출력하
	 */
	private static void test03() {
		int i = 1;	// 초기값
		int cnt = 0;	// 갯수 출력 변
		while (i <= 100) {
			if (i % 2 == 0) {
				System.out.printf("%5d ", i);
				cnt++;
			}
			i++;
		}
		System.out.println(" end i = " + i + " | 짝수의 개수 cnt = " + cnt);
	}
	
	/*
	 * 1 ~ 100까지 숫자 출력 
	 * 조건 1 : 5의 배수에는 하트 조건 
	 * 2 : 5의 배수 줄바꿈 조건 
	 * 3 : 하트의 갯수는?
	 */
	private static void test04() {
		int i = 1;	// 초기값
		int cnt = 0;	// 갯수 출력 변
		while (i <= 100) {
			if (i % 5 == 0) {
				System.out.printf("%5c\n ", '❤');
				cnt++;
			} else {
				System.out.printf("%5d", i);
			}
			i++;
		}
		System.out.println(" end i = " + i + " | 하트의 개수 cnt = " + cnt);
		
	}
	
	public static void main(String[] args) {
		test01();
		System.out.printf("\n======================================\n");
		test02();
		System.out.printf("\n======================================\n");
		test03();
		System.out.printf("\n======================================\n");
		test04();

	}// main end







}// WhileTest end

