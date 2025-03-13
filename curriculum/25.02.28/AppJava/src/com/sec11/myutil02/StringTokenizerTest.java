package com.sec11.myutil02;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String[] args) {
		String str = "java,jdbc,servlet/jsp,spring/JDBCTemplate";
		StringTokenizer st = new StringTokenizer(str, ",/");
		while (st.hasMoreTokens())
			System.out.println(st.nextToken());
	}

}