package com.sec04;

public class ReturnTest2 {
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == 2) {
					return;
				}
				System.out.println(i + ", " + j);
			}
		}
	}
}
	



