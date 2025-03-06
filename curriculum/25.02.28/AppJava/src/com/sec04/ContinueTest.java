package com.sec04;

public class ContinueTest {
	public static void main(String[] args) {
		int a = 0;
		do {
			a++;
			if (a % 2 == 0)
				continue;
			System.out.printf("%5d", a);
		} while (a < 10);
	}
}
