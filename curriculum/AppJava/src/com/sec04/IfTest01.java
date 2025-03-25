package com.sec04;

import java.util.Scanner;

public class IfTest01 {
	public static void main(String[] args) {
		
		// Scanner' next()_공백(스페이스바, 탭, 엔터) nextLine()_개행문자를 기준 
		
		
		
		// 한문자를 입력받아 문자가 소문자이면 "소문자 입니다" 출력하자.
		Scanner sc = new Scanner(System.in);
		char ch = '\0'; 	// 0 ~ 65535	\0 means null
		System.out.print("한문자를 입력하세요 : ");
		
		ch = sc.next().charAt(0);		// 입력받은 문자열에서 sc.next(), 첫번째 한글자 위치의 문자 리턴 charAt(0)
		if (Character.isLowerCase(ch))
			System.out.println("소문자 입니다. ^.^ ");
		
		sc.close();
	}
}

/*
 * ch = sc.next().charAt(0); is equal to
 * 
 * String input_str = sc.next(); char ch_res = input_str.charAt(0);
 */