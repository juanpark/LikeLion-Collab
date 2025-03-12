package com.set07.exam;

import com.set07.exam02.AA;

public class BB extends AA{
	private int c;

	public BB() {
		System.out.println("BB' 기본생성자. ");
	}
	
	public BB(int i, int j, int k) {
		super(i, j);
		this.c = k;
		
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
	public int getRes() {		
		return  (getA() + getB()) -getC(); 
	}

}
