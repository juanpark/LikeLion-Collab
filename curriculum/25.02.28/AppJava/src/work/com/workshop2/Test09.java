package work.com.workshop2;

/*Q9. 다음 코드의 실행 결과는?
String text = "Java\n21\nRocks";
text.lines().forEach(System.out::println);
(1) Java 21 Rocks (2) Java\n21\nRocks
(3) Java
21
Rocks
(4) 예외 발생*/

public class Test09 {

	public static void main(String[] args) {
		
		String text = "Java\n21\nRocks";
		text.lines().forEach(System.out::println);

	}

}
