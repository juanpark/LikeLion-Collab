package com.sec03;

import java.util.Random;

// Create Objects through API Constructors and call Methods

public class MTest02 {

	public static void main(String[] args) {
		
		// Integer(int)
		// Integer i = new Integer(100); // deprecated way
		Integer i = 100;
		System.out.println(i.doubleValue());
		
		// Integer(String)
		Integer i2 = new Integer("100");
		System.out.println(i2.doubleValue());
		
		
		String str = "abcdefg";	// String str = new String("abcdefg");	// made str Object
		
		System.out.println("length = " + str.length());
		System.out.println("Capitalize = " + str.toUpperCase());
		
		String res = str.toUpperCase();
		System.out.println("Print : " + res + " -> to lower case: " + res.toLowerCase());
		
		// java.util.Random Class, create Object and return integer between 0 ~ 100
		// 1. check constructor 
		// 2. nextInt(int)
		
		java.util.Random r = new java.util.Random();
		System.out.println(r.nextInt(101));
		
		// with "import java.util.Random" on top
		Random r2 = new Random();
		System.out.println(r2.nextInt(101));
		
		// already with java.lang package
		int r3 = (int)(Math.random() * 101); // 0~100
		System.out.println(r3);
	}

}
