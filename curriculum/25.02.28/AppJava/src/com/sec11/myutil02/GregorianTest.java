package com.sec11.myutil02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianTest {

	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar();

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy년 MM월 dd일 aa hh시mm분ss초");

		String str = dateFormat.format(calendar.getTime());
		System.out.println(str);
		
		if (calendar.isLeapYear(calendar.get(Calendar.YEAR)))
		      System.out.println("현재 : "+ calendar.get(Calendar.YEAR) +" 는 윤년입니다.");
		    else
		    	System.out.println("현재 : "+ calendar.get(Calendar.YEAR) +"는 평년입니다.");

	}
		
}