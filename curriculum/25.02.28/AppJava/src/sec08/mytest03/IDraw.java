package com.sec08.mytest03;

/*
 public interface IDraw {
 public abstract int getDraw();
 }

 abstract class my implements IDraw {
 }
 */

public interface IDraw {
	public static final int line = 1;
	public static final int circle = 2;
	public static final int rect = 3;

	int getDraw();

	default int getPoint() {
		return 10;
	}
	static void foo() {
		System.out.println("foo");
	}
}



