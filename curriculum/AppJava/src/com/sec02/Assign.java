package com.sec02;

public class Assign {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;
		int c = 30;
		int d = 10;

		a += 50;		// a = a + 50 = 60
		b *= 40;		// b = b * 40 = 20 * 40 = 800
		c += a * b;		// c = a * b = 30 + (60 * 800) = 30 + 48000 = 48030
		d %= 3;			// d = d % 3 = 10 % 3 = 1

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);

	}
}
