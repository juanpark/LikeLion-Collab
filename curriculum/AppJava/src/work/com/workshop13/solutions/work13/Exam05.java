package work.com.workshop13.solutions.work13;

import java.util.ArrayList;
import java.util.Random;

public class Exam05 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		Random rand = new Random();

		// 두 ArrayList에 랜덤한 0~9 정수 10개씩 저장
		for (int i = 0; i < 10; i++) {
			list1.add(rand.nextInt(10)); // 0~9
			list2.add(rand.nextInt(10)); // 0~9
		}

		// 리스트 출력 (선택적: 디버깅용)
		System.out.println("첫 번째 리스트: " + list1);
		System.out.println("두 번째 리스트: " + list2);
		System.out.println("\n결과:");

		// 나눗셈 수행
		for (int i = 0; i < 10; i++) {
			int numerator = list1.get(i);
			int denominator = list2.get(i);

			try {
				int result = numerator / denominator;
				System.out.println(numerator + "/" + denominator + " " + result);
			} catch (ArithmeticException e) {
				System.out.println(numerator + "/" + denominator + " 분모가 0입니다");
			}
		}
	}
}
