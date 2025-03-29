package work.com.workshop12.workshop.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertDate {
	
	// Using Locale.Korean option to solve language issue
	public String convert (Date date, int type) {
		
		String result = switch (type) {
			case 1 -> new SimpleDateFormat("yyyy-MM-dd").format(date);
			case 2 -> new SimpleDateFormat("yy년 M월 d일 EEEE", Locale.KOREAN).format(date);
			case 3 -> new SimpleDateFormat("yyyy-MM-dd H:m:s a", Locale.KOREAN).format(date);
			default -> "선택할 수 있는 타입이 아닙니다";
		};
		
		return result;
		
	}
}
