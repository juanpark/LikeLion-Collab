package com.sec04;
import java.util.Scanner;

public class NestedTest {
	public static void main(String[] args) {

		int com = (int) (Math.random() * 10) + 1;
		int count = 0;
		int user;
		Scanner sc = new Scanner(System.in);
		System.out.println("*** 숫자를 맞추어 보세요(1~10) ***\n");
		while (true) {
			System.out.print("숫자 입력 : ");
			user = sc.nextInt();
			count++;
			if (com > user) {
				System.out.println("컴퓨터의 숫자가 더 큽니다.");
			} else if (com < user) {
				System.out.println("컴퓨터의 숫자가 더 작습니다.");
			} else {
				break;
			}
		}// while end
		System.out.println(count + "번만에 정답입니다.");
		
		sc.close();
	}// main end
}// NestedTest end




