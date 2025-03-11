package com.sec07.mytest03;

public class StaticInitTest {

	static int i = 10;
	static {
		System.out.println("Static i=" + i++);
	}

	public static void main(String[] args) {
		System.out.println("Main  " + StaticInitTest.i);
		for (int i = 0; i < 5; i++) {
			new StaticInitTest();
		}
		System.out.println("Main  " + StaticInitTest.i);
	}
}
