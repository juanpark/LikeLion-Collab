package com.sec12.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest01 {

	public static void main(String[] args) {
		 
		// Interface BiFunction<T, U, R>    R apply(T t, U u) -> T, U를 받아서 R로 리턴 
		BiFunction<String, String,String> bi = (x, y) -> {      
		      return x + y;
		    };
		    
		// BiFunction<String, String,String> bi = (x, y) -> x + y;     
		    
	    System.out.println("bi = " + bi.apply("foo", "bar"));
	    
	    
	    Function<String,String> f = x-> x+" !";		    
	    
	    // default <V> BiFunction<T,U,V> andThen (Function<? super R, ? extends V> after
	    // apply("Getting Start", " java") 호출되서 문자열이 합한 스트링이 리턴되고 andThen() 호출만큼 실행된다.
	    System.out.println(bi.andThen(f).andThen(f).apply("Getting Start", " java")); // applies <<< right to left
	}
}
