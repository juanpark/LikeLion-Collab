package com.sec02;

// 지역변수는 메소드안에 선언하는 변수
// 멤버변수는 클래스안에 선언하는 변수
// 클래스에서 선언할 때 static은 공유가 된다 
public class ArithOperator {
	static int result = 0;
	static int value01 = 50;
	static int value02 = 20;
	
	public void prn() {
		result = value01 + value02;
		System.out.println(value01 + " + " + value02 + " = " + result);

		result = value01 - value02;
		System.out.println(value01 + " - " + value02 + " = " + result);

		result = value01 * value02;
		System.out.println(value01 + " * " + value02 + " = " + result);

		result = value01 / value02;
		System.out.println(value01 + " / " + value02 + " = " + result);

		result = value01 % value02;
		System.out.println(value01 + " % " + value02 + " = " + result);
	}
	
	public static void main(String[] args) {
			
			// getting temp address for .prn
			new ArithOperator().prn();
			System.out.println("===================");
			new ArithOperator().prn();
			System.out.println("===================");
			System.out.println(ArithOperator.result);

	}

}
