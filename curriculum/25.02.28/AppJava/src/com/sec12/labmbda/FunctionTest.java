package com.sec12.labmbda;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		
		    Function<Integer,String> M_fun = (i)-> Integer.toString(i);	  
		   
		    System.out.println(M_fun.apply(100).length());
		    System.out.println(M_fun.apply(1000).length());
	}

}
