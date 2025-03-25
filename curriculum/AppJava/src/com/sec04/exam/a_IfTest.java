package com.sec04.exam;

public class a_IfTest {

	public static void main(String[] args) {
		
		// if a is bigger than 0, prints positive number
		System.out.println(" ex) 만일에 a가 0볻 크면 \"양수\" 출력");
		int a = 100;
		if (a > 0) {	// 결과가 트루 명령을 수행한다.
			System.out.println(a);
		}
	
		System.out.println(" ex) 만일에 a가 0볻 크면 \"양수\" 출력, 그렇지 않으면 \"아니잖아!!!\"");
		if (a > 0) {
			System.out.println(a);
		} else {
			System.out.println("아니잖아!!!");
		}
		
		System.out.println("===================================================");
		
		int num = 10;
		if (num > 0) {
			System.out.println("양수");
		} else if (num < 0) {
			System.out.println("음수");
		} else {
			System.out.println("0 입니다");
		}
	}
		
}
