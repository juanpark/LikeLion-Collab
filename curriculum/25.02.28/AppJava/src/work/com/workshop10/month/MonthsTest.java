package work.com.workshop10.month;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MonthsTest {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
		System.out.print("월을 입력하세요 (1~12): ");
		int month = sc.nextInt();
		if (IntStream.rangeClosed(1, 12).noneMatch(n -> n == month)) {
			System.out.println("입력된 값이 잘못 되었습니다");
		} else {//DEBUG
			System.out.println(month);
		}
	}

}
