package work.com.workshop1;

public class Test04 {

	public static void main(String[] args) {
		
		char ch = 'G'; // 다른 문자로 변경하여 테스트 가능
		// 삼항 연산자를 사용하여 영문자인지 판별
		String result = (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') 
		? "입력한 문자 '" + ch + "'는 영문자입니다."
		: "입력한 문자 '" + ch + "'는 영문자가 아닙니다.";
		// 결과 출력
		System.out.println(result);
		
		
		
		/*	 
		 	입력한 문자 'G'는 영문자입니다.
		
		 	삼항 연산자 (ternary operator)
		  	boolean ? 참일 때 : 거짓일 때 ;
		  	
		  	True = 	A && B		AND: 	둘 다 참일 때
		  	True = 	A || B		OR:		둘 중 하나 또는 둘 다 참일 떄
		  	True = 	!A			NOT:	거짓일 때 (반대)
		  	
		  	(ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')
		  	대문자 알파벳 또는 소문자 알파벳에 속할 때
		  	
		 */

	}

}
