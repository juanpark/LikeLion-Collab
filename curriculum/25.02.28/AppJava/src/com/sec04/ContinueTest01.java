package com.sec04;

public class ContinueTest01 {
	public static void main(String[] args) {

		outer : for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 1) // j가 1이면
					continue outer; // label outer가 포함된 LOOP 문의 다음 단계로 넘어간다
				System.out.println("i =" + i + " j =" + j);
			}// inner for
		}// outer for
		System.out.println("===main=======");
	}// main
}// ContinueTest01


