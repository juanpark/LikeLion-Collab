package com.sec07.mytest;

// 생성자 확인, 상속 시 주소 영역 확인  
public class MTest {

	public static void main(String[] args) {
		
		AA a1 = new DD();	// AA(), BB(), DD()
		a1.getHap();		// can access up to AA
		
		BB b1 = new DD();	// AA(), BB(), DD()
		b1.getA();			// can access up to AA, BB
		b1.getB();
		b1.getRes();		// because DD created this, this is no longer BB's getRes() but DD's getRes() (Overriding)
		
		BB b2 = new BB();	// AA(), BB()
		b1.getRes();		// because BB created this, this is BB's retRes()
		
		AA c1 = new BB();	// AA(), BB()
							// can access up to AA
		
		BB b3 = new AA(); 	// not possible because memory 
		
		
		// testing constructors:
		// new AA();
		// new BB();
		// new DD();	// AA() BB() DD()
	}

}
