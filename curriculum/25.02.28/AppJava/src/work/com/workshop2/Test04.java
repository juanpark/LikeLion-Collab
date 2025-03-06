package work.com.workshop2;

/*Q4. 다음 코드의 실행 결과는 무엇인가?
String input = "Java 21 is awesome!";
System.out.println(input.replaceAll("\\d+", "XX"));
(1) JavaXXis awesome! (2) JavaXX is awesome! (3) Java 21 is awesome! (4) 예외 발생*/

public class Test04 {

	public static void main(String[] args) {
		String input = "Java 21 is awesome!";
		System.out.println(input.replaceAll("\\d+", "XX"));

	}

}
