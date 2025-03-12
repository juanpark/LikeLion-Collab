package com.test;

abstract class ABC {
	
	public abstract void prn();
	public abstract void disp();
	
}

class XX extends ABC { // 부모 추상 클래스의 추상 메소드를 재정의하거나 나도 추상이 되거나 (강제성 부여) 

	@Override
	public void prn() {
		System.out.println("XX' prn");
		
	}

	@Override
	public void disp() {
		System.out.println("XX' disp");
		
	}
	
}

class YY extends ABC {

	@Override
	public void prn() {
		System.out.println("YY' prn");
		
	}

	@Override
	public void disp() {
		System.out.println("YY' disp");
		
	}
	
}


public class MTest {
	
	/*
	 * public static void view(ABC obj) { 
	 * // 하나의 부모타입을 통해 여러 자식 객체를 참조할 수 있도록 하는 개념
	 * // 메소드를 오버라이딩 해서 실행 시점에서 객체의 실제 타입에 따라 적절한 메소드가 실행되도록 한다. [동적바인딩] 
	 * 		obj.disp();
	 * 		obj.prn(); 
	 * }
	 */

	public static void view(ABC obj) {	
		// 하나의 부모타입을 통해 여러 자식 객체를 참조할 수 있도록 하는 개념 
		// 메소드를 오버라이딩 해서 실행 시점에서 객체의 실제 타입에 따라 적절한 메소드가 실행되도록 한다. [동적바인딩] 
		// -> 는 = : return 
		switch (obj) {
			case XX xx -> {
				xx.disp();
				xx.prn();
			}
			case YY yy -> {
				yy.disp();
				yy.prn();
			}
			default -> System.out.println("알 수 없는 타입니야");
		}
	}
	
	public static void main(String[] args) {
		ABC a1 = new XX();
		ABC a2 = new YY();
		
		view(a1);
		view(a2);
	
		
	}

}
