package com.sec07.mytest03;

public class StaticTest {	
	public static int static_var = 0;

	public StaticTest() {
		static_var++;
	}

	public static void main(String[] args) {
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		StaticTest st3 = new StaticTest();
		StaticTest st4 = new StaticTest();
		System.out.println(StaticTest.static_var);
	}
}
