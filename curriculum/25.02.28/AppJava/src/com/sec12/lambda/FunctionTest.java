package com.sec12.lambda;

import java.util.function.Function;

public class FunctionTest {

	
	
	public static void main(String[] args) {
		
		    // Interface Function<T,R>    R apply(T t)   T로 받아 R로 리턴
			Function<Integer,String> M_fun = (i)-> Integer.toString(i);	  
		   
		    System.out.println(M_fun.apply(100).length());
		    System.out.println(M_fun.apply(1000).length());
	}

}
