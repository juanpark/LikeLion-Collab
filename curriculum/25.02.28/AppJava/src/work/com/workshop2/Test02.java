package work.com.workshop2;

/*Q2. 다음 코드의 실행 결과는 무엇인가?
String multiLine = """
Hello
World
""";
System.out.println(multiLine.stripIndent());
(1) Hello\n World
(2) Hello\n World
(3) Hello\nWorld
(4) Hello\n World*/

public class Test02 {
	public static void main(String[] args) {
		String multiLine = """
				Hello
					World
		""";
		
		System.out.println(multiLine.stripIndent());
	}
		
}
