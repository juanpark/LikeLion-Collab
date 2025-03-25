package work.com.workshop2;

/*Q5. 다음 코드의 실행 결과는?
String str = "Java";
System.out.println(str.indent(4));
(1) "Java" (변화 없음) (2) " Java" (앞에 공백 4칸 추가)
(3) "Java " (뒤에 공백 4칸 추가) (4) 예외 발생*/

public class Test05 {

	public static void main(String[] args) {
		String str = "Java";
		System.out.println(str.indent(4));
	}

}
