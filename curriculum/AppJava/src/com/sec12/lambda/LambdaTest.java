package com.sec12.lambda;

public class LambdaTest {

	@FunctionalInterface 	//함수형 인터페이스 체크 
	interface Fun01{
		public String prn(String name);	// 매개인자 메서드
	}
	
	interface Fun02{
		public String prn02(); // 매개인자 없는 매서드
	}
	
	@FunctionalInterface
	interface Fun03{
		public void say(String name);    // 문자열을 받아서 출력하는 메서드 
	}
	
	
	
	public static void main(String[] args) {
		
		Fun01 m_name = name -> "hello!!" + name;	// (name)을 생략
		System.out.println("m_name :" + m_name.prn(" Hong"));
		
		Fun02 m_test = () -> "테스트 ";    // {}와 return 키워드 생략. return "테스트";
		System.out.println("m_name :" + m_test.prn02());
		
		Fun03 m_test03 = (name) -> System.out.println("hello " + name);
		m_test03.say("정길동");

	}

}
