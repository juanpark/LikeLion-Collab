package com.sec03;

public class MyClass {
	private int a;
	
	// constructor
	public MyClass() {
		// if not declared, default constructor is provided
		System.out.println("I am default constructor " + this.a);
	}
	// overloading
	public MyClass(int a ) {
		this.a = a;
		System.out.println("overload constructor " + this.a);
	}
	
	
	public static void main(String[] args) {

		// MyClass m = new MyClass();
		// System.out.println(m);
		
		// overloading
		@SuppressWarnings("unused")
		MyClass m1 = new MyClass(200);
	}

}
