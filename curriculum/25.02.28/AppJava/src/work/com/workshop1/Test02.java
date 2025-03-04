package work.com.workshop1;

public class Test02 {

	public static void main(String[] args) {
		String s1 = "1";
		String s2 = "2";
		boolean bnx = false;
		char c1 = 'A';
		char c2 = 'B';
		char c3 = '1';
		char c4 = '2';
		int inx = 2;
		
		/*	char를 int로 캐스팅 하였을 시 각 ASCII 값
			System.out.println((int)c1);
			System.out.println((int)c2);
			System.out.println((int)c3);
			System.out.println((int)c4);
		
			65
			66
			49
			50
		*/
		
		// Solution
		System.out.println(s1 + s2);
		System.out.println(!bnx);
		// System.out.println(((int)c1) + ((int)c2));
		System.out.println(c1 + c2);
		// System.out.println(((int)c3) + inx);
		System.out.println(c3 + inx);
		System.out.println(c3 + c4);
		
		/*
		 	12
			true
		 	131
		 	51
		 	99
		
		
			System.out.println(((int)c1) + ((int)c2)); 	= 131
			System.out.println(c1 + c2); 				= 131
			System.out.println(((int)c3) + inx);		= 51
			System.out.println(c3 + inx);				= 51
			
			Java에서 작은 크기의 데이터 타입을 가지고 연산을 수행하면 자동형 변환 (implicit type promotion)을
			통해 해당 값을 int 타임으로 변환 후 연산을 수행하기 때문에 explicit type casting이 없어도 위에서는
			동일한 상황이다.
			
			char (2바이트) < int (4바이트)
			
			Java에서는 byte, short, char 타입끼리 연산을 수행하면 int 타입으로 변환된다.
		*/
	}

}
