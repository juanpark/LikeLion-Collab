package com.sec04;
import java.util.Scanner;

public class SwitchTest01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0;
		char op = '\0';
		System.out.print(" 두수 와 연산자를 입력(+,-,*,/) : ");
		a = sc.nextInt();
		b = sc.nextInt();
		op = sc.next().charAt(0);

		switch (op) {
			case '+' :
				System.out.println(a + " + " + b + " = " + (a + b));
				break;
			case '-' :
				System.out.println(a + " - " + b + " = " + (a - b));
				break;
			case '*' :
				System.out.println(a + " * " + b + " = " + (a * b));
				break;
			case '/' :
				System.out.println(a + " / " + b + " = " + (double) a / b);
				break;
			default :
				System.out.println("연산자 error");
		}// switch end
		
		sc.close();
	}// main end
}// SwticTest01 end
