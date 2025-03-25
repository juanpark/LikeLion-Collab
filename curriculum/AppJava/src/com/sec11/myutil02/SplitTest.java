package com.sec11.myutil02;

public class SplitTest {

	public static void main(String[] args) {		
		String str ="java,jdbc,servlet/jsp,spring/JDBC|Template";		
		String[] res= str.split(",|\\/|\\|", 7);
		
		for(String result : res){
			System.out.println(result);
		}			

	}

}
