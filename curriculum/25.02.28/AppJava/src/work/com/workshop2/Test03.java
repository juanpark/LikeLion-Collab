package work.com.workshop2;

/*Q3. translateEscapes() 메서드는 어떤 기능을 수행하는가?
(1) 문자열 내부의 escape 문자를 실제 문자로 변환한다.
(2) 문자열을 소문자로 변환한다.
(3) 문자열의 줄바꿈을 자동으로 제거한다.
(4) 문자열을 JSON 형식으로 변환한다.
*/
	
public class Test03 {
	public static void main(String[] args) {

		String str = "\"Path: C:\\\\Users\\\\Juan\"";
		String result = str.translateEscapes();
		
		System.out.printf("Original:\n%s\n", str);
		System.out.printf("Translated Escape:\n%s", result);
		


	}
}
