package work.com.workshop13.com.elite;

import java.util.HashSet;
import java.util.stream.Collectors;

/*
1. 조건
스페이스가 없는 String을 입력 받아 문자들을 HashSet에 저장 후 이를 이용하여 출력 한다.
String 형태의 문자열을 스페이스 없이 eclipse 에서 argument로 받아 들여 각각의 문자를
HashSet에 넣고 출력 한다. (출력 순서는 무시 한다.)
 */
public class SetTest {
	public static void main(String[] args) {
		HashSet<Character> charSet = null;
		
		if (args == null || args.length == 0 || args[0] == null || args[0].isEmpty()) {
			System.out.println("Argument 하나 입력 해주세요.");
			return;
		} else {
			charSet = args[0]
				    .chars()	// String을 유니코드 값으로 스트리밍 개시 (문자별)
				    .mapToObj(c -> (char) c)	// 유니코드 int 값을 다시 char로 캐스팅  
				    .collect(Collectors.toCollection(HashSet::new));	// char를 HashSet에 저장
		} // if else end
		
		System.out.println(charSet);
		
		/*// Enhanced For Loop으로 프린트 할 시:
		for (char c : charSet) {
			System.out.print(c + " ");
		}
		System.out.println();
		*/

	}// main end
} // class end
