package work.com.workshop7.com.elite.test04;

import java.util.Scanner;

public class ExTest {

	public static void main(String[] args) {
		// 2부터 5까지의 정수형 데이터만을 argument로 입력 받아, 1부터 입력 받은 데이터까지의 합을 출력한다.
		// 단, 입력 받은 데이터가 2부터 5까지의 범위를 벋어나면 “입력 값에 오류가 있습니다.”를 출력한다.
		
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		double result = 0;
		
		System.out.println("Input int: ");
		num = sc.nextInt();
		
		try {
			result = Calc.getSum(num);
		} catch (InvalidException IE) {
			System.out.println("입력 값에 오류가 있습니다.");
			return;
		}
		System.out.println("결과 값: " + result);
		

	}

}
