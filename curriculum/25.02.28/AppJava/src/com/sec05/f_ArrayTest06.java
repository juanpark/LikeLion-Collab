package com.sec05;

// 가변 배열 :배열을 선언할 때 행을 선언하고 열은 생성되는 값에 의해서 정해지는 형태 
public class f_ArrayTest06 {
	public static void main(String[] args) {
		int[][] myArrays = new int[3][];	// 2차원의 행을 명시
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
