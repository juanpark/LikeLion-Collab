package com.sec12.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntSupplier;

public class MethodRefTest {

	public static void main(String[] args) {
		String s = "java8"; 
		IntSupplier supplier = s :: length; //매개인자 없는 메소드 
		System.out.println(supplier.getAsInt());

		Consumer <String> c = System.out :: println; //매개인자 1개
		c.accept("java8");
		 
		
		IntBinaryOperator op = Integer :: sum; //매개인자 2개 	
		System.out.println(op.applyAsInt(100, 200));
		
		
		Function<Integer, Double> fd = Math::sqrt;//static메소드 
		System.out.println(fd.apply(100));
		
	}

}
