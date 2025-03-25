package com.sec11.myutil02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest02 {
	public static void main(String[] args) {
		String str = new String("java2 java3 java4");
		System.out.println("대상문자열 :  " + str);
		System.out.println("--------------------------\n");
		Pattern pattern01 = Pattern.compile("java");
		Matcher matcher01 = pattern01.matcher(str);
		System.out.println("java를 찾아서 spring으로 변경");
		System.out.println(matcher01.replaceAll("spring"));
		System.out.println("--------------------------\n");

		Pattern pattern02 = Pattern.compile("java");
		Matcher matcher02 = pattern02.matcher(str);
		StringBuffer appStrBuf = new StringBuffer();
		while (matcher02.find()) {
			matcher02.appendReplacement(appStrBuf, "spring");
		}
		matcher02.appendTail(appStrBuf);
		System.out.println("java를 찾아서 spring으로 변경");
		System.out.println(appStrBuf.toString());
	}
}
