package com.sec07.mytest;

public class BB extends AA{
	private int c;

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
	public int getRes() {		
		return  getHap()-getC(); 
	}

}
