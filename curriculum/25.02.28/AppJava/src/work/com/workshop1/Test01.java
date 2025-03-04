package work.com.workshop1;

public class Test01 {

	public static void main(String[] args) {
		int x = 100;
		double y = 3.14;
		char c = 'A';
		boolean b = true;
		
		/* Solution 1
		System.out.println("정수형 변수의 값은 " + x + "이며, 자료형은 " + ((Object)x).getClass().getSimpleName() + " 입니다");
		System.out.println("실수형 변수의 값은 " + y + "이며, 자료형은 " + ((Object)y).getClass().getSimpleName() + " 입니다");
		System.out.println("정수형 변수의 값은 " + c + "이며, 자료형은 " + ((Object)c).getClass().getSimpleName() + " 입니다");
		System.out.println("정수형 변수의 값은 " + b + "이며, 자료형은 " + ((Object)b).getClass().getSimpleName() + " 입니다");
		
		정수형 변수의 값은 100이며, 자료형은 Integer 입니다
		실수형 변수의 값은 3.14이며, 자료형은 Double 입니다
		정수형 변수의 값은 A이며, 자료형은 Character 입니다
		정수형 변수의 값은 true이며, 자료형은 Boolean 입니다
		*/
		
		// Solution 2
		System.out.println("정수형 변수의 값은 " + x + "이며, 자료형은 int 입니다");
		System.out.println("실수형 변수의 값은 " + y + "이며, 자료형은 double 입니다");
		System.out.println("정수형 변수의 값은 " + c + "이며, 자료형은 char 입니다");
		System.out.println("정수형 변수의 값은 " + b + "이며, 자료형은 boolean 입니다");
		
		/*
		정수형 변수의 값은 100이며, 자료형은 int 입니다
		실수형 변수의 값은 3.14이며, 자료형은 double 입니다
		정수형 변수의 값은 A이며, 자료형은 char 입니다
		정수형 변수의 값은 true이며, 자료형은 boolean 입니다
		*/
		
		// 질문: Java는 Python과 같이 primitive type를 바로 출력할 수 있는 type() 같은 메서드는 없는것인지?
		
	}

}
