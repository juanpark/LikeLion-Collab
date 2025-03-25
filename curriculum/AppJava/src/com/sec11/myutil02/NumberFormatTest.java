package com.sec11.myutil02;

import java.text.NumberFormat;

public class NumberFormatTest {

	public static void main(String[] args) {
		 long ex01 = 1000000L ;
         long ex02 = 2000000L ;
         double ex03 = 0.50D;
        NumberFormat nf1 = NumberFormat.getNumberInstance (); 
        NumberFormat nf2 = NumberFormat.getCurrencyInstance (); 
        NumberFormat nf3 = NumberFormat.getPercentInstance (); 

        System.out.println (nf1.format (ex01)); 
        System.out.println (nf2.format (ex02)); 
        System.out.println (nf3.format (ex03) ); 
      

	}
}
