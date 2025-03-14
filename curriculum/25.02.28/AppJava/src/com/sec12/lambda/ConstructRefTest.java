package com.sec12.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/*	메소드 생성자 참조 jdk8 ::
 * 
 *  생성자 참조  class명::new 
 * 
 * 
 * 
 * 
 * 
 * 
 */



class MyConstruct {
	String name;
	int age;

	public MyConstruct() {
		name = "길동_default constructor";
		age = 23;
	}

	public MyConstruct(String name) {
		super();
		this.name = name;
		age = 25;
	}

	public MyConstruct(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "MyConstruct [name=" + name + ", age=" + age + "]";
	}
}

public class ConstructRefTest {
	public static void main(String[] args) {

		Supplier<MyConstruct> func = MyConstruct::new; // 매개인자 없는 기본 생성자를 호출 하곘다.
		//람다식  		Supplier<MyConstruct> func = () -> new MyConstruct(); 		
		MyConstruct res = func.get();
		System.out.println(res);

		Function<String, MyConstruct> func1 = MyConstruct::new; // 매개인자 하나로 생성자를 호출 하겠다.
		
		//람다식 	Function<String, MyConstruct> func1 =(name) ->new MyConstruct(name);
		System.out.println(func1.apply("Dominica"));

        BiFunction<String, Integer, MyConstruct> func3 = MyConstruct::new;	// 매개인자 두개로 생성자를 호출 하곘다.
		// 람다식  BiFunction<String, Integer, MyConstruct> func3=(name, age)->new MyConstruct(name,age);
		System.out.println(func3.apply("RuRi", 10));
	}
}






