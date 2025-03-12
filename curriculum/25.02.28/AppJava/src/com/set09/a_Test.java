package com.set09;

public class a_Test {

	public static void main(String[] args) {
		int a = 100;
		int b = 5;
		int res = 0;
		
		try {
		res = a / b;
		// ArithmethicException AE = new java.lang.ArtithmeticException("/ by zero")
		} catch (ArithmeticException AE) { 
			
			System.out.println("Exception: " + AE.getMessage());
		} catch (RuntimeException RE) {
			System.out.println("RuntimeException");
		} catch (Exception E) {
			System.out.println("Other Exception");
		} finally {
			System.out.println("Required at End");
		}
		System.out.printf("a = %5d  b=%5d  res=%5d \n", a, b, res);
		
		
	}
}
