package com.sec12.lambda;

public class LambdaTest02 {

	@FunctionalInterface
	interface Func{
		public int Calc(int a, int b);	// only requires one abstract method
		public static int Calc02(int a, int b) {return a + b;}
		default int Calc03(int a, int b) {return a + b;}
	}
	
	public static void main(String[] args) {
		
		
		Func add = (int a, int b) -> {
			return a + b;
		};
		Func sub = (int a, int b) -> a - b;
		Func mult = (int a, int b) -> a * b;
		Func div = (int a, int b) -> a / b;
		Func mod = (int a, int b) -> a % b;
		
		System.out.println(add.Calc(5,6));
		System.out.println(sub.Calc(10, 8));
		System.out.println(mult.Calc(4, 5));
		System.out.println(div.Calc(11, 5));
		System.out.println(mod.Calc(4, 5));
		System.out.println(mod.Calc(5, 4));
		
		System.out.println(add.Calc03(5, 6)); // default is also callable with lambda expression
	}
}
