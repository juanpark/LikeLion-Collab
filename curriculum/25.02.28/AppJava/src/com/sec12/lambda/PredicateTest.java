package com.sec12.lambda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;


public class PredicateTest {

	public static void main(String[] args) {
			Predicate<String> i  = (s)-> s.length() >10; //(1)
		    System.out.println(i.test("getting strart java"));	//(2)	   
		    
		    IntPredicate p1 = n -> (n % 3) == 0; //(3)
		    IntPredicate p2 = n -> (n % 5) == 0;//(4) 		    
		    IntPredicate p_res = p1. and (p2); //(5)
		    
		    System.out.println(p_res.test(3)); //(6)
		    System.out.println(p_res.test(4)); //(7)
		    
		    IntPredicate p_res02 = p1. or (p2); //(8)
		    System.out.println(p_res02.test(5)); 
		    System.out.println(p_res02.test(15));
		    
		    
		    Predicate<String> str  = Predicate.isEqual("Dominica_kim");//(9)
		    System.out.println(str.test("Dominica_kim"));
		    
		  
	}

}
