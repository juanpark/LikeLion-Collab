package com.sec05;

public class g_ArrayCopyTest {
	public static void main(String[] args) {
		int myArray[] = { 100, 200, 300, 400, 500 };
		int hold[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + "  ");
		}
		System.out.println();
		for (int j = 0; j < hold.length; j++) {
			System.out.print(hold[j] + "  ");
		}
		System.out.println();
		System.arraycopy(myArray, 0, hold, 0, myArray.length);

		System.out.println("<==arraycopy result ==>");
		for (int j = 0; j < hold.length; j++) {
			System.out.print(hold[j] + "  ");
		}

	}
}