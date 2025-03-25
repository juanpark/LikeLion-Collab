package com.sec11.myutil02;

import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class TimezoneTest {
	public static void main(String[] args) {

		TimeZone tz = null;
		GregorianCalendar date = new GregorianCalendar();

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss (z Z)");

		tz = TimeZone.getTimeZone("Asia/Seoul");
		df.setTimeZone(tz);
		System.out.format("%s%n%s%n%n", tz.getDisplayName(),
				df.format(date.getTime()));

		tz = TimeZone.getTimeZone("Greenwich");
		df.setTimeZone(tz);
		System.out.format("%s%n%s%n%n", tz.getDisplayName(),
				df.format(date.getTime()));

		tz = TimeZone.getTimeZone("America/New_York");
		df.setTimeZone(tz);
		System.out.format("%s%n%s%n%n", tz.getDisplayName(),
				df.format(date.getTime()));

		tz = TimeZone.getTimeZone("Pacific/Honolulu");
		df.setTimeZone(tz);
		System.out.format("%s%n%s%n%n", tz.getDisplayName(),
				df.format(date.getTime()));

		tz = TimeZone.getTimeZone("Asia/Shanghai");
		df.setTimeZone(tz);
		System.out.printf("%s%n%s%n%n", tz.getDisplayName(),
				df.format(date.getTime()));

	}
}
