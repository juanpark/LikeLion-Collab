package com.sec04;

public class ReturnTest {
	public static void main(String[] args) {
		int i;
		i = 10;
		while (true) {
			if (i == 0)
				return;
			System.out.print(i +" ");
			i--;
		}
	}
}


