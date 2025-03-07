package com.sec05;

public class d_Array1 {

	public static void main(String[] args) {
	
		Test();

	}

	private static void Test() {
		// 1) 배열선언 생성 출력 확인

		int[] ar02 = new int[] {10, 20, 30, 40, 50, 60};
		
		Prn(ar02);
		
		// 역순으로 출력
		reversePrn(ar02);
		
	}
	public static void reversePrn(int[]ar) {

		System.out.println("=== 반복 for문 출력 ===");
		for (int i = ar.length - 1; i >= 0; i--) {
			System.out.printf("%5d ", ar[i]);	
		}
		System.out.println();		
		
	}
	
	
	public static void Prn(int[]ar) {

		System.out.println("=== 반복 for문 출력 ===");
		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%5d ", ar[i]);	
		}
		System.out.println();		
		
	}

}
