package com.sec10.mstring;

public class c_StringTest {

	public static void main(String[] args) {

		String s = "aBcAbCabcABC";

		System.out.println("4번째 문자 chartAT: " + s.charAt(3));
		System.out.println("abc의 위치 indexOf: " + s.indexOf("abc"));

		System.out.println("s의 길이 length: " + s.length());
		System.out.println("a를 R로 변환 replace: " + s.replace('a', 'R'));

		System.out.println("aBc만 추출 substring: " + s.substring(0, 3));
		System.out.println("모두 대문자로 출력  uppercase: " + s.toUpperCase());

		System.out.println("대문자 C 의 위치 : " + (s.indexOf("C") + 1) + "번째");
	}

}
