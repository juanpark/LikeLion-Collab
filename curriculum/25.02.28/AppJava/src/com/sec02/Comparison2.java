package com.sec02;

public class Comparison2 {

	public static void test() {
		int num, assign;
		num = 10;

		int a = 3;
		int b = 4;

		System.out.println((a > b++) && (a < b++));// false & true = false
		System.out.println("a=" + a + "  b=" + b);
	}
	
	public static void main(String[] args) {
		
		test();
		
		int a = 10;
		int b = 2;
		
		System.out.println( a > b );
		System.out.println( a & b );  // bitwise operation 
		System.out.println( (a > b) && (b == a) ); 
		


	}

}