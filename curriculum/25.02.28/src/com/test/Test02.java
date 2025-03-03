package com.test;

import static java.lang.Thread.sleep;


public class Test02 {

	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			Test01.prn01();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
