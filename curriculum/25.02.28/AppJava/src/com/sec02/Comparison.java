package com.sec02;

public class Comparison {

	public static void main(String[] args) {

		int num, assign;
		num = 10;

		int a = 3;
		int b = 4;

		System.out.println((a > b++) && (a < b++));// false & true = false
		System.out.println("a=" + a + "  b=" + b);

	}

}
