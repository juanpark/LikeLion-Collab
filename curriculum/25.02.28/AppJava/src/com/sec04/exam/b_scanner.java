package com.sec04.exam;
import java.util.Scanner;
/*
 * 콘솔로 값을 입력 받는 방법
 * java.util.Scanner			-> 타입의 입력이 메소드로 정해 있다.
 * java.io.BufferedReader		-> 문자열 입력 특화 / 예외처리
 * java.lang.System.in.read()	-> 한글자 특화, 바이트별 처리, 병합 필요 사용 불편 
 */




public class b_scanner {
	
	public static void main(String[] args) {
	
		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.print("input i : "); Double i = sc.nextDouble();
		 * System.out.println("입력받은 값 :" + i);
		 * 
		 * sc.close();
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("Input Name: ");
		String name = sc.nextLine();
		System.out.printf("Input Address: ");
		String addr = sc.nextLine();
		System.out.printf("Input Telephone Number: ");
		String tel = sc.nextLine();
		System.out.printf("%-10s %-10s %-10s \n", name, addr, tel);
		
		sc.close();
		
	}
}
