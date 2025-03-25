package com.sec08.mytest03;

/*
 public interface IDraw {
 public abstract int getDraw();
 }

 abstract class my implements IDraw {	// my class abstract 추상인 이유는 추상 메서드 getDraw()를 재정의하지 않아서이다.
 }
 */

public interface IDraw {
	public static final int line = 1;
	public static final int circle = 2;
	public static final int rect = 3;

	int getDraw(); // public abstract int getDraw();

	default int getPoint() {
		return 10;
	}
	static void foo() {
		System.out.println("foo");
	}
}



