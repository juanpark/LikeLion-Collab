package com.sec04;
import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month;
		System.out.print("원하는 달을 입력하세요 : ");
		month = sc.nextInt();

		switch (month) {
		case 12:
		case 1:
		case 2:		System.out.println("겨울");
			        break;
		case 3:
		case 4:
		case 5:  	System.out.println("봄");
			        break;
		case 6:
		case 7:
		case 8:     System.out.println("여름");
		            break;
		case 9:
		case 10:
		case 11:  	System.out.println("가을");
			        break;
		
		default:	System.out.println("원하는 달이 없습니다");
					
		}//switch end
		
		sc.close();
	}//main end
}//SwitchTest end


