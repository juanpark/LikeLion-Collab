package com.sec04;

public class BreakTest {
	public static void main(String[] args) {
		int i;
		i = 5;
		System.out.println("Countdown start!");
		
		while (true) {
			if (i == 0)
				break;
			System.out.println(i);
			i--;
		}	
	}
}

