package com.sec02.exam;


public class b_exam {

	// instance methods
	public void prn() {
		System.out.println("b_exam'prn -> non-static ");
	}
	
	public static void main(String[] args) {
		b_exam m = new b_exam();
		
		System.out.println(m.toString());
		System.out.println(m);
		m.prn();

	}

}
