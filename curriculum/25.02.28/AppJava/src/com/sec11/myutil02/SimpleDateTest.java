package com.sec11.myutil02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateTest {

	public static void main(String[] args) throws ParseException {	
		 
		// 시스템의 현재 날짜
		Date now = new Date();
		Calendar now2 = Calendar.getInstance();
		 
		// Date 타입을 형식화
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String dateWithFormat = sdf.format(now);
		System.out.println(dateWithFormat); 		 
		// Calendar 타입을 형식화
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String calendarWithFormat = sdf2.format(now2.getTime());
		System.out.println(calendarWithFormat); 
	}
	
}
