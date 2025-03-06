package com.sec04;

public class NestedTest01 {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if ((j == 4) && (i == 1 || i == 5)) {
					System.out.print( "* ");
				} else if ((j == 2 || j == 4) && (i == 2 || i == 4)) {
					System.out.print("* ");
				} else if ((j == 1 || j == 5) && i == 3) {
					System.out.print("* ");
				} else {
					System.out.print(" ");
				}//if end
			}//inner for
			System.out.println();
		}//outer for
	}//main
}//NestedTest01




