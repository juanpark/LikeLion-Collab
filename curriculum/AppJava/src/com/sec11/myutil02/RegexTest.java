package com.sec11.myutil02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {
		String str = new String("jdk7 jdk8 jdk9 jdk10 jdk20 jdk21");
		Pattern pattern1 = Pattern.compile("(jdk\\d)\\s(jdk\\d)\\s(jdk\\d)");
		Matcher matcher1 = pattern1.matcher(str);
		System.out.println(matcher1.matches());
		System.out.println("---------------" + "\n");

		Pattern pattern2 = Pattern.compile("\\s");
		String[] splitStr = pattern2.split(str);
		for (int i = 0; i < splitStr.length; i++) {
			System.out.println(splitStr[i]);
		}
		System.out.println("---------------" + "\n");

	}

}
