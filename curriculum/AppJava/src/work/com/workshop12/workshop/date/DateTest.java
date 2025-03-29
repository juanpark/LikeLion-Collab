package work.com.workshop12.workshop.date;

import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// 2025년 8월 30일 토요일 21시 48분 10초 설정
		Calendar cal = Calendar.getInstance();
		cal.set(2025, Calendar.AUGUST, 30, 21, 48, 10); 
		// Month는 0부터 시작 (8월 -> Calendar.August)
		Date date = cal.getTime();
		
		ConvertDate converter = new ConvertDate();
		
		// Type 별 출력
		System.out.println("1) " + converter.convert(date,  1));
		System.out.println("1) " + converter.convert(date,  2));
		System.out.println("1) " + converter.convert(date,  3));
		

	}

}
