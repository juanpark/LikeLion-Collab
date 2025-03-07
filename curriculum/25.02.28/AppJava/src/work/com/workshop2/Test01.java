package work.com.workshop2;

/*Q1. 다음 코드의 실행 결과는 무엇인가?
String s1 = "Hello";
String s2 = "World";
String s3 = s1 + s2;
System.out.println(s3 == "HelloWorld");
(1) true (2) false (3) 컴파일 오류 (4) 예외 발생*/

public class Test01 {
	
	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = "World";
		
		String s3 = s1 + s2;
		System.out.println(s3 == "HelloWorld");
		
	}

}
