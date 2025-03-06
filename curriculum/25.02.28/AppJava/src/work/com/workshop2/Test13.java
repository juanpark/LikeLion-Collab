package work.com.workshop2;

/*Q13. 다음 코드의 실행 결과는?
String str = "Hello,World";
String[] arr = str.split(",");
System.out.println(arr[1]);
(1) Hello (2) , (3) World (4) 예외 발생*/

public class Test13 {

	
	
	public static void main(String[] args) {
		String str = "Hello,World";
		String[] arr = str.split(",");
		System.out.println(arr[1]);

	}

}
