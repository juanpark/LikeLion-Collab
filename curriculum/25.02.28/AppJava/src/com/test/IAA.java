package com.test;

// static final, abstract method, default, static method
// interface -> 생성자 없다, new 할 수 없다, 다중 구현한다.

public interface IAA { // 
	int a=10; 	// 반드시 초기값 -> public static final int a = 10;
	public static final int b = 20;
	
	void prn(); // same as -> public abstract void prn(), abstract class needs to add abstract or abstract method
	public abstract void disp();
	
	default void view() {	// 재정의 가능 : 문법은 있으나 사용은 안함 (호환 때문에 필요) 	
		System.out.println(a);
	}
	
	 static void view02() {	// 재정의 안됨 : IAA.view02()로 호출 가능  	
		System.out.println(a);
	}
	

}
