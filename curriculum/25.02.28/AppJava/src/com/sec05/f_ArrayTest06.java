package com.sec05;

public class f_ArrayTest06 {
	public static void main(String[] args) {
		int[][] myArrays = new int[3][];
		myArrays[0] = new int[] { 1, 2, 3 };
		myArrays[1] = new int[] { 5, 4, 3, 2, 1 };
		myArrays[2] = new int[] { 11, 22 };
		
		for (int i = 0; i < myArrays.length; i++) {
			for (int j = 0; j < myArrays[i].length; j++) {
				System.out.printf("%5d", myArrays[i][j]);
			}
			System.out.println();
		}
	}
}
