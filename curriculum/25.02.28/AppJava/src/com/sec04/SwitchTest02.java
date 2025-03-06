package com.sec04;
import java.util.Scanner;

public class SwitchTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("좋아하는 요일은 ?<ex :토>  :");
		String dayOfWeek = sc.next();

		switch (dayOfWeek) {
			case "월" :
				System.out.println("항상 활기찬 기운이 가졌습니다 ");
				break;
			case "화" :
			case "수" :
			case "목" :
				System.out.println("전진하는 활력소와 열정을 가졌습니다. ");
				break;
			case "금" :
				System.out.println("낭만을 가진 멋진 분입니다");
				break;
			case "토" :
			case "일" :
				System.out.println("마음의 여유를 갈망합니다. ");
				break;
			default :
				System.out.println(dayOfWeek + "은 허망한 삶입니다.");
		}
	}
}



