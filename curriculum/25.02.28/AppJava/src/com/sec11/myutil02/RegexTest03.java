package com.sec11.myutil02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest03 {

	public static void main(String[] args) {
		String str = new String("java1 java2 java3");
		Pattern pattern01 = Pattern
				.compile("(java\\d)\\s(java\\d)\\s(java\\d)");
		Matcher matcher01 = pattern01.matcher(str);
		if (matcher01.find()) {
			System.out.println(matcher01.group(0)); // 대상 전체 패턴
			System.out.println(matcher01.group(1)); // ()첫번째 그룹
			System.out.println(matcher01.group(2));// ()두번째 그룹
			System.out.println(matcher01.group(3));// ()세번째 그룹
		}

	}

}

