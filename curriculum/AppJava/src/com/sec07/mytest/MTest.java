package com.sec07.mytest;

// 생성자 확인, 상속 시 주소 영역 확인  
public class MTest {

	public static void main(String[] args) {
		
		AA a1 = new DD();	// AA(), BB(), DD()
		a1.getHap();		// can access up to AA
		System.out.println("=========================");
		
		BB b1 = new DD();	// AA(), BB(), DD()
		b1.getA();			// can access up to AA, BB
		b1.getB();
		b1.getRes();		// because DD created this, this is no longer BB's getRes() but DD's getRes() (Overriding)
		System.out.println("=========================");
		
		BB b2 = new BB();	// AA(), BB()
		b1.getRes();		// because BB created this, this is BB's retRes()
		System.out.println("=========================");
		
		AA c1 = new BB();	// AA(), BB()
							// can access up to AA
		
		// BB b3 = new AA(); 	// not possible because memory space is not available
		
		System.out.println("==========================");
		check_instance(a1);
		check_instance(b1);
		check_instance(b2);
		check_instance(c1);
		
		
		// testing constructors:
		// new AA();
		// new BB();
		// new DD();	// AA() BB() DD()
	}
	
	public static void check_instance(AA obj) {
		if (obj instanceof DD) {
			System.out.println("객체는 DD 클래스의 인스턴스이다. ");
		} else if (obj instanceof BB) {
			System.out.println("객체는 BB 클래스의 인스턴스이다.. ");
		} else if (obj instanceof AA) {
			System.out.println("객체는 AA 클래스의 인스턴스이다.. ");
		} else {
			System.out.println("ERROR");
		}
	}

}
