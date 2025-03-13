package com.sec11.myutil02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		// (국제표준시각(UTC, GMT) 1970/1/1/0/0/0 으로부터 경과한 시각)
		// 밀리초 단위(*1000은 1초), 음수이면 이전 시각
		long time1 = System.currentTimeMillis();
		System.out.println(time1);

		Date today = new Date(); // 현재시간 출력
		System.out.println(today);

		long time2 = System.currentTimeMillis();
		System.out.println((time2 - time1) / 1000.0);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("현재날짜 : " + sdf.format(today));
	}
}
