package work.com.workshop1;

public class Test07 {
	public static void main(String[] args) {
		
		// 테스트할 문자 변수 선언
		char ch = 'G'; // 다른 문자로 변경하여 테스트 가능

		// 결과 출력
		printResult(ch);
		}
		// 문자가 영문자인지 판별하는 static 메소드
		public static boolean isAlphabet(char ch) {
		return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
		}
		// 결과를 출력하는 static 메소드
		public static void printResult(char ch) {
		String result = isAlphabet(ch)
		? "입력한 문자 '" + ch + "'는 영문자입니다."
		: "입력한 문자 '" + ch + "'는 영문자가 아닙니다.";
		System.out.println(result);
		}
}

/* 입력한 문자 'G'는 영문자입니다.
 * 입력한 문자 ' '는 영문자가 아닙니다.
 *  
 * Method가 어떻게 argument를 주고 받는지 이해하면 이미 다 완성 된 문제 
 * 알파벳인지 파악하는 논리는 Test04 복붙하면 됨
 * 
 * 1. main에서 char ch = 'G' 알아볼 문자 declare + assign
 * 2. main에서 printResult(ch) 메소드를 부르고 argument로 ch 값 복사해서 보냄
 * 
 * 3. printResult(ch) 메소드에서 ch 값을 받고
 * 4. 바로 isAlphabet(ch) 메소드 호출, 마찬간지로 ch 값 복사해서 보냄 
 * 
 * 5. isAlphabet(ch) 메소드에서 ch 값을 받고 불리언 비교로 참인지 거짓인지 return 값으로 보냄
 * (둘 다, 또는둘 중 하나만 참이면 참)
 * 
 * 6. 마지막으로 문제 4에서 본 삼항 연산자 (ternary operator) 논리 그대로
 * 		
 * 		String result = boolean ? 참일 때 : 거짓일 때 ;
 * 
 * 		리턴 값이 참이면? 참일 때 문자 스트링을 result에 넣기 : ;
 *  	리턴 값이 거짓이면? : 거짓일 때 문자 스트링을 result에 넣기;
 *  	그리고 마지막으로 result의 스트링 프린트하기
 */
