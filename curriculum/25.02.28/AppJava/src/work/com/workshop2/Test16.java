package work.com.workshop2;

/*Q16. String.join() 메서드의 역할은?
(1) 문자열을 하나의 리스트로 분할한다.
(2) 주어진 문자열들을 특정 구분자로 연결한다.
(3) 문자열을 대문자로 변환한다.
(4) 문자열을 JSON 형식으로 변환한다.*/

public class Test16 {

	public static void main(String[] args) {
		
		String[] textArray = {"Java", "World", "Is", "Here", "!!!"};
		String joined = String.join("*", textArray);
		String joined1 = String.join(" ", textArray);
		
		System.out.println(joined);
		System.out.println(joined1);
	}
}
