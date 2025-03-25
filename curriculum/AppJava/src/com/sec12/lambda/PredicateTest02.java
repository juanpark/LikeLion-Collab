package com.sec12.lambda;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;

public class PredicateTest02 {

	public static void main(String[] args) {
		
		// Q1. IntPredicate를 활용해서 짝수 이면서 7의 배수인지 판별 해보자.
		
		// Interface Predicate<T t>	     boolean test(T t)
	      
	    IntPredicate p1 = n -> (n % 2) == 0; // 짝수인지
	    IntPredicate p2 = n -> (n % 7) == 0;// 7의 배수인지 	    
	    IntPredicate p_res = p1. and (p2); // 둘다인지
	    
	    System.out.println(p_res.test(14)); // 14 % 2 == 0 AND 14 % 7 == 0 > T AND T > True
	    System.out.println(p_res.test(15));
	    System.out.println(p_res.test(21));
	    System.out.println(p_res.test(28));
	    
	    // Q2. Interface BiPredicate<T, U>를 사용해 보자 boolean test(T t, U u)
	    BiPredicate<Integer, Integer> bi = (x,y) -> x > y;
	    
	    System.out.println("bi.test(10. 7) = " + bi.test(10, 7));
	    
	}
}
