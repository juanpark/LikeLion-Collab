package com.sec11.myutil02;

import java.text.DecimalFormat;

public class DecimalFormatTest {

	public static void main(String[] args) {
		double ex01 = 1251.24D;
		DecimalFormat m_format01 = new DecimalFormat("###, ###. ###"); 
		System.out.println(m_format01.format(ex01));

		double ex02 = 1251.24D;
		DecimalFormat m_format02 = new DecimalFormat("000,000.000");
		System.out.println(m_format02.format(ex02));

		double ex03 = 1251.24D;
		DecimalFormat m_format03 = new DecimalFormat("\u00A4###, ###");
		System.out.println(m_format03.format(ex03));

		double ex04 = 0.50D;
		DecimalFormat m_format04 = new DecimalFormat("### %");
		System.out.println(m_format04.format(ex04));

		double ex05 = 0.50D;
		DecimalFormat m_format05 = new DecimalFormat(" '%'### %");
		System.out.println(m_format05.format(ex05));

	}

}
