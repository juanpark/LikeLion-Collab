package work.com.workshop10.com.elite;

import java.util.Scanner; 

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 (5 ~ 10): ");
		int input = sc.nextInt();
		if (input > 10 || input < 5) {
			System.out.println("다시 입력하세요");
			return;
		}
		
		
		int evenCount = Calc.calculate(input);
		System.out.println("짝수의 합: " + evenCount);
	}

}
