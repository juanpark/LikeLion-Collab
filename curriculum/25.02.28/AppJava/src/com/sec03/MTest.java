package com.sec03;

// 두 개의 정수를 관리하는 클래
class Test {
	// 은닉된 멤버변
	private int a;
	private int b;
	
	//setter - void
	public void setA(int a) {
		this.a = a; // 전달 및 변경: 지역변수 a를 통해서 값을 받아 this.a로 대입해서 값 전달 변
	}
	public void setB(int b) {
		this.b = b;
	}
	
	//getter
	public int getA() {
		return a; // this.a 혀재 멤버변수 값을 리
	}
	public int getB() {
		return b; // this.b
	}
}


public class MTest {

	public static void main(String[] args) {
		//메모리 할당 객체 생
		Test m = new Test();
		Test m1 = new Test();
		Test m2 = new Test();
		
		//할당된 주소를 확
		System.out.println("각 주소를 출력해보자");
		System.out.println(m.toString() + "\t" + m);
		System.out.println(m.toString() + "\t" + m1);
		System.out.println(m.toString() + "\t" + m2);
		
		// 할당된 초기갑을 확인 => 멤버 변수는 객체가 생성될 때 생성자에 의해서 초기값을 대입 후 메모리 할당된다. 
		System.out.printf("m a = %5d, b = %5d \n", m.getA(), m.getB());
		System.out.printf("m a = %5d, b = %5d \n", m1.getA(), m1.getB());
		System.out.printf("m a = %5d, b = %5d \n", m2.getA(), m2.getB());
		
		
		/*
		Test t1 = new Test();
		t1.setA(100);
		t1.setB(200);
		
		System.out.println(t1.getA());
		System.out.println(t1.getB());
		
		t1.setA(1000);
		System.out.println(t1.getA());
		*/

	}

}
