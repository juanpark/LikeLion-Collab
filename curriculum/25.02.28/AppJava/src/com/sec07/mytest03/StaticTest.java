package com.sec07.mytest03;

public class StaticTest {	
	public static int static_var = 0;
	private int non_static;
	
	public StaticTest() {
		static_var++;
		// non_static++;
	}
	
	/*public int getNon_static() {
		return non_static;
	}*/

	public static void main(String[] args) {
//		StaticTest st1 = new StaticTest();
//		StaticTest st2 = new StaticTest();
//		StaticTest st3 = new StaticTest();
//		StaticTest st4 = new StaticTest();
		
		for (int i = 0; i < 5; i++) {
			new StaticTest();
		}
		System.out.println(StaticTest.static_var);
		
		/*for (int i = 0; i < 5; i++) {
			System.out.println(new StaticTest().getNon_static());*/
		}

	}

