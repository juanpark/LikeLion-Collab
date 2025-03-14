package com.sec12.labmbda;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		
		Supplier<String> s = () -> "abc";
		System.out.println(s.get()); // abc 를 리턴

		IntSupplier y = () -> 100;
		System.out.println(y.getAsInt());//100을 리턴

		DoubleSupplier d = () -> 90.7;
		System.out.println(d.getAsDouble());//90.7을 리턴

	}

}
