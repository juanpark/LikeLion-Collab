package com.sec05;

public class b_Array2 {

	public static void main(String[] args) {
	
		Test();

	}

	private static void Test() {
		// 1) 배열선언 생성 출력 확인
		// 나열형 값을 선언과 동시에 대입했다
		//int[] ar = {10, 20, 30, 40, 50};
		int ar02[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		
		// 2) 배열의 주소를 넘겨서 메소드에서 출력 해보자.
		System.out.println("호출전 : " + ar02[0]);	// ar[0] = 0
		Prn(ar02);
		System.out.println("호출후 : " + ar02[0]);	// ar[0] = 1000
	}
	
	public static void Prn(int[]ar) {
		ar[0] = 1000;
		System.out.println("=== 반복 for문 출력 ===");
		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%5d ", ar[i]);		// ar[0] = 1000
		}
		System.out.println();
		
		
	}

}
