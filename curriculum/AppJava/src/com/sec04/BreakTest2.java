package com.sec04;

public class BreakTest2 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 2) {
					break;
				}
				System.out.println("i =" + i + " j =" + j);
			}//inner for end
		}//outer for end
	}//main  end
}//BreakTest01  end




