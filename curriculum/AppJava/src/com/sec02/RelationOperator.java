package com.sec02;

public class RelationOperator {

	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		boolean c = false;
		c = a < b;

		System.out.println(a + "  < " + b + " 의 결과는 " + c);

		c = a > b;
		System.out.println(a + "  > " + b + "  의 결과는 " + c);

		c = a >= b;
		System.out.println(a + " >= " + b + " 의 결과는 " + c);

		c = a <= b;
		System.out.println(a + " <= " + b + " 의 결과는 " + c);

		c = a == b;
		System.out.println(a + " == " + b + " 의 결과는 " + c);

		c = a != b;
		System.out.println(a + " != " + b + " 의 결과는 " + c);
	}

}
