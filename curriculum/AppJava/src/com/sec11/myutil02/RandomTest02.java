package com.sec11.myutil02;

import java.util.Random;
public class RandomTest02 {

	public static void main(String[] args) {
		Random m_rand = new Random();
		int i_r;
		i_r = m_rand.nextInt();
		System.out.println("정수 범위 : " + i_r);

		i_r = m_rand.nextInt(10);
		System.out.println("0~9: " + i_r);

		i_r = m_rand.nextInt(10) + 1;
		System.out.println("1 ~ 10 : " + i_r);

		i_r = m_rand.nextInt(15) + 20;
		System.out.println("20 ~ 34: " + i_r);

		i_r = m_rand.nextInt(20) - 10;
		System.out.println("-10~  9: " + i_r);
	}

}
