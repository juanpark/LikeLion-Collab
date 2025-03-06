package com.sec04;

public class WhileTest01 {
	public static void main(String[] args) {
		int i = 1;
		int evenhap = 0;// 짝수의 합을 저장할 변수
		int oddhap = 0; //홀수의 합을 저장할 변수
		while (i <= 100) {
			if ((i % 2) == 0) {
				evenhap += i;
			} else {
				oddhap += i;
			}
			i++;
		}
		System.out.println("짝수의 합 : " + evenhap);
		System.out.println("홀수의 합 : " + oddhap);
	}
}

