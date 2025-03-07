package com.sec05;

public class a_Array {

	public static void main(String[] args) {
	
		Test();

	}

	private static void Test() {
		// 1) 배열선언 생성 출력 확인
		// 나열형 값을 선언과 동시에 대입했다
		int[] ar = {10, 20, 30, 40, 50};
		// int ar02[] = {10, 20, 30, 40, 50};
		System.out.println("=== case01 ar 직접 출력 ===");
		System.out.println(ar[0]);
		System.out.println(ar[1]);
		System.out.println(ar[2]);
		System.out.println(ar[3]);
		System.out.println(ar[4]);
		
		System.out.println("=== case02 반복 for문 출력 ===");
		for (int i = 0; i < 5; i++) {
			System.out.println(ar[i]);
		}
		
		System.out.println("=== case03 제네릭 타입 for문 (for-each loop) 출력 ===");
		for (int res : ar) {
			System.out.println(res);
		}
		
		
		
		
		
	}

}
