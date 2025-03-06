package work.com.workshop2;
import java.util.List;

/*Q8. String.lines() 메서드의 역할은 무엇인가?
(1) 문자열을 한 줄씩 리스트로 반환한다.
(2) 문자열을 정렬한다.
(3) 문자열을 대문자로 변환한다.
(4) 문자열을 JSON 형식으로 변환한다.
*/

public class Test08 {

	public static void main(String[] args) {
		
		String multiLine = "Hello World\nBye World\nJava World\n";
		
		List<String> results = multiLine.lines().toList();
		
		System.out.println(results);
			
		
	}

}
