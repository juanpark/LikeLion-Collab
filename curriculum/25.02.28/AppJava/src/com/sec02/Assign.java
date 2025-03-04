package com.sec02;

public class Assign {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;
		int c = 30;
		int d = 10;

		a += 50;
		b *= 40;
		c += a * b;
		d %= 3;

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);

	}
}
