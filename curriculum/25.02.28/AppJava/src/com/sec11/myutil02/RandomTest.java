package com.sec11.myutil02;

public class RandomTest {

	public static void main(String[] args) {

		double x = Math.random();
		System.out.println("실수형값  0.0 ~ 1.0: x = " + x);

		int r1 = (int) (Math.random() * 10) ;
		System.out.println("정수형  -0 ~ 9: r1 = " + r1);

		int r2 = (int) (Math.random() * 6) + 3;
		System.out.println("정수형  3 ~  8:  r2 = " + r2);

	
			int r3 = (int) (Math.random() * 21) - 10;
			System.out.println("정수형  -10  ~  10: r3 = " + r3);
		
			

	}

}
