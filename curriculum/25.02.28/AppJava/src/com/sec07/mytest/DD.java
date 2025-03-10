package com.sec07.mytest;

public class DD extends BB {
	
	private int d;

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	
	@Override
	public int getRes() {
		
		return super.getRes() * getD();
	}
	
	public static void main(String[] args) {
		
		DD d1 = new DD();	// AA(), BB(), DD() all created in memory
		d1.setA(100);
		d1.setB(50);
		d1.setC(5);
		d1.setD(2);
		String res = String.format("( %d + %d ) - %d * %d = %d \n", d1.getA(), d1.getB(), d1.getC(), d1.getD(), d1.getRes());
		
		System.out.println("result: " + res);
		
	}

}
