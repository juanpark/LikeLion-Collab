package com.sec01;

public class Test_char {
	public static void main(String[] args) {
		System.out.println('A');
		System.out.println('김');
		System.out.println('金');
		System.out.println('\uc548');//'안'을 2byte 유니코드로  
		System.out.println('\ub155');//'녕'을 2byte 유니코드로 
		System.out.println('1');//숫자지만 ' ' 로 감싸지면 문자
		System.out.println("Hello World!");
		System.out.println("200"+100);//문자열 다음 +는  연결문자
	}
}
