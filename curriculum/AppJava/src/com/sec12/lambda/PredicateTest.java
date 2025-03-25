package com.sec12.lambda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

// Predicate 입력값을 받아서 조건을 체크한 후 true 또는 false을 반환하는 인터페이스 boolean test(T t),
//  -> 조건 집합을 정의하고 지정된 객체가 조건을 충족하는지 유무를 확인 하는 메서드 

public class PredicateTest {

	public static void main(String[] args) {
		
			// Interface Predicate<T t>	     boolean test(T t)
			Predicate<String> i  = (s)-> s.length() >10; //(1)
		    System.out.println(i.test("getting start java"));	//(2)	   
		    
		    // IntPredicate
		    IntPredicate p1 = n -> (n % 3) == 0; //(3)
		    IntPredicate p2 = n -> (n % 5) == 0;//(4) 		    
		    IntPredicate p_res = p1. and (p2); //(5)
		    
		    System.out.println(p_res.test(3)); //(6) 3 % 3 == 0 AND 0 % 5 == 0 > T AND F > False
		    System.out.println(p_res.test(4)); //(7) 4 % 3 == 0 AND 4 % 5 == 0 > F AND F > False
		    System.out.println("if n is 15 = " + p_res.test(15)); //(7) 15 % 3 == 0 AND 15 % 5 == 0 > T AND T > True
		    
		    IntPredicate p_res02 = p1. or (p2); //(8)
		    System.out.println(p_res02.test(5)); 
		    System.out.println(p_res02.test(15));
		    
		    
		    Predicate<String> str  = Predicate.isEqual("Dominica_kim");//(9)
		    System.out.println(str.test("Dominica_kim"));
		    
		  
	}

}
