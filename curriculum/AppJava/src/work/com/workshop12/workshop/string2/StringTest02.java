package work.com.workshop12.workshop.string2;

import java.util.Scanner;

public class StringTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("백만원 대 입력: ");
		int number = sc.nextInt();
		
		ConvertString format = new ConvertString();
		
		System.out.println(format.convert(number) + "원");
		
		sc.close();
	}

}
