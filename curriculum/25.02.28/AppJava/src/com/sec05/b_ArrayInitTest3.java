package com.sec05;

import java.util.Arrays;

// 상속구조, 타입으로 선택을 구현하는 switch(Object){} -> 객체의 캐스팅 
/*
 * switch (expression) {
 * case pattern1 -> statement;
 * case pattern2 when condition -> statement;
 * default -> statement;
 */
public class b_ArrayInitTest3 {
	public static void main(String[] args) {
		// 각 기본형 타입 배열 선언 및 초기화 (기본값을 확인하기 위해)
		char[] c = new char[2];
		byte[] b = new byte[2];
		boolean[] bool = new boolean[2];
		int[] i = new int[2];
		long[] l = new long[2];
		float[] f = new float[2];
		double[] d = new double[2];
		Object[] o = new Object[2];

		printArray("byte", b);
		printArray("char", c);
		printArray("boolean", bool);
		printArray("int", i);
		printArray("long", l);
		printArray("float", f);
		printArray("double", d);
		printArray("object", o);
	}

	public static void printArray(String type, Object array) {
		System.out.println("==========================");

		// `switch` 패턴을 활용한 타입 검사 (JDK 21 이상)
		String output = switch (array) {
		case boolean[] a -> Arrays.toString(a); //case boolean[] a:   return Arrays.toString(a);
		case byte[] a -> Arrays.toString(a);
		case char[] a -> Arrays.toString(a);
		case int[] a -> Arrays.toString(a);
		case long[] a -> Arrays.toString(a);
		case float[] a -> Arrays.toString(a);
		case double[] a -> Arrays.toString(a);
		case Object[] a -> Arrays.toString(a);
		default -> "Unknown Type";
		};

		System.out.println(type + " 배열: " + output);
	}

}
