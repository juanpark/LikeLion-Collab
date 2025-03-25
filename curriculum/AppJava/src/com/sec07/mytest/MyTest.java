package com.sec07.mytest;

import java.util.Calendar;
import java.util.GregorianCalendar;

// API를 확인 후 상속을 받자. 
public class MyTest extends GregorianCalendar {

	public MyTest() {};
	public MyTest(int year, int month, int dayOfMonth) {
		super(year, month, dayOfMonth);		// GregorianCalendar(int year, int month, int dayOfMonth)
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MINE!!!";
	}
	
	public static void main(String[] args) {
		
		MyTest m1 = new MyTest();
		System.out.println(m1.toString());
		
		MyTest m2 = new MyTest(2025, 3, 11);
		System.out.println(m2.get(Calendar.YEAR) + "/" + m2.get(Calendar.MONTH) + "/" + m2.get(Calendar.DAY_OF_MONTH));
		m2.set(YEAR, 2020);
		m2.set(MONTH, 11);
		System.out.println(m2.get(Calendar.YEAR) + "/" + m2.get(Calendar.MONTH) + "/" + m2.get(Calendar.DAY_OF_MONTH));
		
		


	}



}
