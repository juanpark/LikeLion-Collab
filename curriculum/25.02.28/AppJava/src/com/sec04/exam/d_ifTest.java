package com.sec04.exam;

public class d_ifTest {
	
	// 1. 여러 조건을 조합한 경우
	public static void checkPassOrFail(int score, boolean isPassed) {
		if (score >= 80 && isPassed && score % 2 != 0) {
			System.out.println("우수한 성적으로 합격했습니다.");
		} else {
			System.out.println("조건을 충족하지 못했습니다.");
		}
	}

	// 2. 범위와 논리 연산자를 조합한 경우
	public static void checkEligibility(int age, String country) {
		if ((age >= 18 && age <= 30) || country.equals("Korea")) {
			System.out.println("조건을 충족합니다.");
		} else {
			System.out.println("조건을 충족하지 않습니다.");
		}
	}

	// 3. 객체 유형과 조건을 조합한 경우
	public static void checkStringLength(Object obj) {
		if (obj instanceof String && ((String) obj).length() > 5) {
			System.out.println("길이가 5보다 큰 문자열입니다.");
		} else {
			System.out.println("조건을 충족하지 않습니다.");
		}
	}

	// 4. 삼항 연산자와 조합한 경우
	public static void checkEvenPositive(int num) {
		boolean isEven = (num % 2 == 0) ? true : false;
		String result = (num > 0) ? "양수" : "음수 또는 0";

		if (isEven && result.equals("양수")) {
			System.out.println("짝수 양수입니다.");
		} else {
			System.out.println("조건을 충족하지 않습니다.");
		}
	}

	public static void main(String[] args) {
		// 1. 여러 조건을 조합한 경우
		checkPassOrFail(85, true);
		checkPassOrFail(75, false);

		// 2. 범위와 논리 연산자를 조합한 경우
		checkEligibility(25, "USA");
		checkEligibility(35, "Korea");
		checkEligibility(17, "Japan");

		// 3. 객체 유형과 조건을 조합한 경우
		checkStringLength("HelloWorld");
		checkStringLength(123);

		// 4. 삼항 연산자와 조합한 경우
		checkEvenPositive(10);
		checkEvenPositive(-5);
	}

}
