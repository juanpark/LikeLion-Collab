package com.sec12.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		
		// Interface Consumer<T>	Gets arguments but does not return -> void 	accept(T t)
		// 입력 값을 받아서 특정 작업을 수행하고 반환값이 없는 인터페이스 
		Consumer<String> c = s -> System.out.println(s); 
		c. accept ("abc");
		
		Consumer<String> c1 = s -> System.out.println("c1=" + s); 
		Consumer<String> c2 = s -> System.out.println("c2=" + s); 
		Consumer<String> c_res= c1. andThen (c2); 
		c_res.accept("abc");
		
		
		// public Interface BiConsumer<T,U> Gets two arguments but does not return -> void accept(T t, U u)
		// Q1. 100, 200 입력받아 합을 출력 하자 
		BiConsumer<Integer, Integer> sum = (a, b) -> System.out.println(a + b);
		sum.accept(100, 200);	
		
	}

}
