package com.sec04.exam;

public class c_IfTest {
	public static void main(String[] args) {
		// 1. 숫자 범위 확인 (정수형)
		checkIntegerRange(1000);
		checkIntegerRange(Integer.MAX_VALUE + 1L);

		// 2. 문자 범위 확인
		checkCharacterRange('A');

		// 3. 배수 확인
		checkMultiple(15, 3);
		checkMultiple(16, 3);

		// 4. 약수 확인 : 약수는 특정 수를 나누어떨어지게 하는 수
		checkDivisor(12, 4);
		checkDivisor(13, 4);
	}

	// 1. 숫자 범위 확인 (정수형)
	public static void checkIntegerRange(long num) {
		if (num >= Byte.MIN_VALUE && num <= Byte.MAX_VALUE) {
			System.out.println(num + "는 byte 범위 내에 있습니다.");
		} else if (num >= Short.MIN_VALUE && num <= Short.MAX_VALUE) {
			System.out.println(num + "는 short 범위 내에 있습니다.");
		} else if (num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE) {
			System.out.println(num + "는 int 범위 내에 있습니다.");
		} else if (num >= Long.MIN_VALUE && num <= Long.MAX_VALUE) {
			System.out.println(num + "는 long 범위 내에 있습니다.");
		} else {
			System.out.println(num + "는 long 범위를 초과합니다.");
		}
	}

	// 2. 문자 범위 확인
	public static void checkCharacterRange(char ch) {
		if (ch >= 0 && ch <= 65535) {
			System.out.println(ch + "는 유니코드 문자 범위 내에 있습니다.");
		}
	}

	// 3. 배수 확인
	public static void checkMultiple(int number, int divisor) {
		if (number % divisor == 0) {
			System.out.println(number + "는 " + divisor + "의 배수입니다.");
		} else {
			System.out.println(number + "는 " + divisor + "의 배수가 아닙니다.");
		}
	}

	// 4. 약수 확인
	public static void checkDivisor(int number, int potentialDivisor) {
		if (number % potentialDivisor == 0) {
			System.out.println(potentialDivisor + "는 " + number + "의 약수입니다.");
		} else {
			System.out.println(potentialDivisor + "는 " + number + "의 약수가 아닙니다.");
		}
	}

}