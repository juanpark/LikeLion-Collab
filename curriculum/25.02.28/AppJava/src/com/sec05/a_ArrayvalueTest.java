package com.sec05;

public class a_ArrayvalueTest {
	public static void main(String[] args) {

		int[] ar = new int[] { 10, 20, 30, 40, 50 };
		System.out.println("ar의 요소의 개수 =" + ar.length);

		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%5d", ar[i]);
		}

		ar = new int[] { 100, 200, 300 };

		System.out.println("\n ar의 재할당된  요소의 개수 =" + ar.length);

		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%5d", ar[i]);
		}
	}

}
