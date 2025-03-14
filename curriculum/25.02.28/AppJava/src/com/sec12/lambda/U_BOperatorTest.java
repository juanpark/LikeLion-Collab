package com.sec12.lambda;

import java.util.function.BinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class U_BOperatorTest {
	public static void main(String[] args) {
		IntUnaryOperator op1 = n -> n * 10; 
		IntUnaryOperator op2 = n -> n + 1; 
		IntUnaryOperator op = op1. compose (op2); 
		System.out.println(op.applyAsInt(2));
		
		UnaryOperator<String> op02 = UnaryOperator. identity (); 
		System.out.println(op02.apply("aaa"));
		
		BinaryOperator<String> op03 = BinaryOperator. minBy ((s1, s2) -> s1.compareTo(s2)); 
		String s_res = op03.apply("aaa", "ddd");
		System.out.println("aaa,ddd 중 작은값 리턴 :" +s_res);
		
		BinaryOperator<String> op04 = BinaryOperator. maxBy ((s1, s2) -> s1.compareTo(s2)); 
		String s_res01 = op04.apply("aaa", "ddd");
		System.out.println("aaa,ddd 중 큰값 리턴 :"+s_res01);
		
		
	}
}
