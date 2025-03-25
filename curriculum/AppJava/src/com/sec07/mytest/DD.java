package com.sec07.mytest;

public class DD extends BB {
	private int d;
	
	public DD() {
		System.out.println("DD' 기본생성자. ");
	}

	public DD(int i, int j, int k, int l) {
		super(i, j, k);
		this.d = l;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	@Override
	public int getRes() {		
		return super.getRes() * this.getD();
	}

	
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * DD d1 = new DD(); // AA() BB() DD() d1.setA(100); d1.setB(50); d1.setC(5);
	 * d1.setD(2); String res = String.format("( %d + %d ) -%d *%d =%d \n",
	 * d1.getA(), d1.getB(), d1.getC(), d1.getD(), d1.getRes());
	 * 
	 * System.out.println("result : " + res);
	 * 
	 * }
	 */
}

