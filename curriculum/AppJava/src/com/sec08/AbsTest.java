package com.sec08;

abstract class My {  // new My() 객체 생성 안한다. -> 후손인 클래스 너가 나를 메모리에 할당해줘 
	public void prn() {
		System.out.println("나  추상의 멤버얌 My's Prn ");
	}
	public abstract void disp();    // {}가 없는 선언만 되어 있는 추상 메소드 (이름만 있고 구현이 없음: 후손이 구현)
}
class myTest extends My { 
	// 1. 추상 클래스를 상속 받은 후손 클래스는 추상클래스의 추상메소드를 반드시 정의해야 한다.
	// 2. 재정의 하지 않으면 추상 클래스가 된다. -> new 객체 생성 불가능 
	@Override
	public void disp() {
		System.out.println(" 그래 난 강제로 정의한 myTest's disp"); // 선조가 선언한 추상 메소드를 후손이 구현 
	}
}
public class AbsTest {
	public static void main(String[] args) {
		// My m=new My(); -> 추상클래스는 new 객체 생성 불가능   
		myTest m = new myTest();    // My(), myTest()
		m.prn();
		m.disp();
		
		My res = new myTest();		// My(), myTest()
		res.disp();					// 후손이 나를 메모리에 올려 준 상황이라 접근 가능 
		res.prn();
	}
}

