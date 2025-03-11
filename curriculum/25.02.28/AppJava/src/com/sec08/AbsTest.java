package com.sec08;

abstract class My {
	public void prn() {
		System.out.println("나  추상의 멤버얌 My's Prn ");
	}
	public abstract void disp();
}
class myTest extends My {
	public void disp() {
		System.out.println(" 그래 난 강제로 정의한 myTest's disp");
	}
}
public class AbsTest {
	public static void main(String[] args) {
		// My m=new My(); 
		myTest m = new myTest();
		m.prn();
		m.disp();
	}
}

