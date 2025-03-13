package com.sec11.myutil02;

import java.util.Scanner;

public class UseDelimiterTest {

	public static void main(String[] args) {
		String str1 = "one, two, three";
		String str2 = "apple orange pineapple";
		Scanner sc1 = new Scanner(str1);
		sc1.useDelimiter(",");// ","로 구분
		while (sc1.hasNext()) {// Scanner 클래스의 hasNext () 메소드
			System.out.println(sc1.next());// next () 메소드를 사용 문자를 분할
		}
		System.out.println();
		Scanner sc2 = new Scanner(str2);// 문자열을 인수 Scanner를 생성
		while (sc2.hasNext()) { // Scanner 클래스의 hasNext () 메소드
			System.out.println(sc2.next());// next () 메소드를 사용 문자를 분할
		}
		sc1.close();
		sc2.close();
	}
}
