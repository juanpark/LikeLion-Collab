package com.sec03;

/*
 * 이름 세 과목 총점, 평균을 구현하는 클래스를 만들자.
 * U_Score
 * 	이름		국어		영어		숙학		총점		평
 * 	홍길동	100		100		100					a1
 * 	정길동	90		90		90					b1
 * 	박길동	80		80		80					c1
 * 
 */

public class U_Score {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @param kor 
	 * @return the kor
	 */
	public int getKor() {
		return kor;
	}



	/**
	 * @param kor the kor to set
	 */
	public void setKor(int kor) {
		this.kor = kor;
	}



	/**
	 * @return the eng
	 */
	public int getEng() {
		return eng;
	}



	/**
	 * @param eng the eng to set
	 */
	public void setEng(int eng) {
		this.eng = eng;
	}



	/**
	 * @return the mat
	 */
	public int getMat() {
		return mat;
	}



	/**
	 * @param mat the mat to set
	 */
	public void setMat(int mat) {
		this.mat = mat;
	}


	public int getTot() {
		return this.getKor() + this.getMat() + this.getEng();
	}
	
	public int getAvg() {
		return this.getTot()/3;
	}

	
	
	
	@Override
	public String toString() {
		return String.format("U_Score [getName()=%s, getEng()=%d, getMat()=%d, getTot()=%d, getAvg()=%d]", getName(),
				getEng(), getMat(), getTot(), getAvg());
	}

	/*
	 * 이름 세 과목 총점, 평균을 구현하는 클래스를 만들자.
	 * U_Score
	 * 	이름		국어		영어		숙학		총점		평
	 * 	홍길동	100		100		100					a1
	 * 	정길동	90		90		90					b1
	 * 	박길동	80		80		80					c1
	 * 
	 */


	public static void main(String[] args) {
		
		U_Score a1 = new U_Score();
		U_Score b1 = new U_Score();
		U_Score c1 = new U_Score();
		
		a1.setName("홍길동");
		a1.setKor(100);
		a1.setEng(100);
		a1.setMat(100);
		
		b1.setName("정길동");
		b1.setKor(90);
		b1.setEng(90);
		b1.setMat(90);
		
		c1.setName("박길동");
		c1.setKor(80);
		c1.setEng(80);
		c1.setMat(80);
		
		System.out.println(a1);
		System.out.println(b1);
		System.out.println(c1);
		
		// 
		System.out.println("=================================");
		
		System.out.printf("%10s %10s %10s \n", a1.getName(), b1.getName(), c1.getName());
		int tot = a1.getTot() + b1.getTot() + c1.getTot();
		System.out.printf(" total_score = %10d \n", tot);
	}

}
