package com.set09;

public class a_Test {

	public static void main(String[] args) {
		int a = 100;
		int b = 0;
		int res = 0;
		
		try {
		res = a / b;
		// ArithmethicException AE = new java.lang.ArtithmeticException("/ by zero")
		} catch (ArithmeticException AE) { 
			System.out.println("Exception: " + AE.getMessage());
		}
		System.out.printf("a = %5d  b=%5d  res=%5d \n", a, b, res);
		
		
	}
}
