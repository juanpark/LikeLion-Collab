package com.sec04;

import java.util.Scanner;

public class ForTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dan = 0;

		System.out.print("원하는 단을 입력하세요 : ");
		dan = sc.nextInt();

		for (int j = 1; j <= 9; j++) {
			System.out.println(dan + "*" + j + "=" + (dan * j) + "	");
		}
	}
}
