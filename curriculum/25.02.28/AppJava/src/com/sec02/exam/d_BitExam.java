package com.sec02.exam;

public class d_BitExam {

	// 1. 두 정수의 비트 연산 및 이진 문자열 변환
	public static void bitwiseOperations(int x, int y) {
		System.out.println("--- 비트 연산 ---");
		System.out.println("x = " + x + ", y = " + y);

		int andResult = x & y;
		int orResult = x | y;
		int xorResult = x ^ y;
		int notResult = ~x;
		int leftShiftResult = y << 2;
		int unsignedRightShiftResult = x >>> 3;

		System.out.println("AND: " + Integer.toBinaryString(andResult));
		System.out.println("OR: " + Integer.toBinaryString(orResult));
		System.out.println("XOR: " + Integer.toBinaryString(xorResult));
		System.out.println("NOT x: " + Integer.toBinaryString(notResult));
		System.out.println("Left Shift y << 2: " + Integer.toBinaryString(leftShiftResult));
		System.out.println("Unsigned Right Shift x >>> 3: " + Integer.toBinaryString(unsignedRightShiftResult));

		System.out.println("AND (16자리): " + String.format("%16s", Integer.toBinaryString(andResult)).replace(' ', '0'));
		System.out.println("OR (16자리): " + String.format("%16s", Integer.toBinaryString(orResult)).replace(' ', '0'));
		System.out.println("XOR (16자리): " + String.format("%16s", Integer.toBinaryString(xorResult)).replace(' ', '0'));
		System.out
				.println("NOT x (16자리): " + String.format("%16s", Integer.toBinaryString(notResult)).replace(' ', '0'));
		System.out.println("Left Shift y << 2 (16자리): "
				+ String.format("%16s", Integer.toBinaryString(leftShiftResult)).replace(' ', '0'));
		System.out.println("Unsigned Right Shift x >>> 3 (16자리): "
				+ String.format("%16s", Integer.toBinaryString(unsignedRightShiftResult)).replace(' ', '0'));
	}

	// 2. 부동소수점 수의 비트 표현 및 16진수 문자열 변환
	public static void floatAndDoubleBits(float f, double d) {
		System.out.println("--- 부동소수점 비트 표현 ---");
		System.out.println("f = " + f + ", d = " + d);

		int floatBits = Float.floatToIntBits(f);
		long doubleBits = Double.doubleToLongBits(d);

		System.out.println("float 이진 표현: " + Integer.toBinaryString(floatBits));
		System.out.println("double 이진 표현: " + Long.toBinaryString(doubleBits));

		System.out.println("float 16진수 표현: " + Integer.toHexString(floatBits));
		System.out.println("double 16진수 표현: " + Long.toHexString(doubleBits));
	}

	// 3. NaN 값 처리 및 판별
	public static void nanHandling() {
		System.out.println("--- NaN 처리 ---");

		double result1 = 0.0 / 0.0;
		double result2 = Math.sqrt(-2.0);
		double result3 = Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY;
		double result4 = Double.NaN * 5.0;
	

		System.out.println("0.0 / 0.0: " + result1 + ", NaN: " + Double.isNaN(result1));
		System.out.println("Math.sqrt(-2.0): " + result2 + ", NaN: " + Double.isNaN(result2));
		System.out.println("Infinity - Infinity: " + result3 + ", NaN: " + Double.isNaN(result3));
		System.out.println("NaN * 5.0: " + result4 + ", NaN: " + Double.isNaN(result4));
		
	}

	public static void main(String[] args) {
		bitwiseOperations(75, 112);
		floatAndDoubleBits(-12.375f, 45.625);
		nanHandling();
	}
}
