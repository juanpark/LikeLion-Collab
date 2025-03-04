package work.com.workshop1;

public class Test06 {

	public static void main(String[] args) {
		
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b);
		char ch = 'A';
		ch = (char) (ch + 2);
		float f = 1.5f;
		long l = 27000000000L;
		float f2 = 0.1f;			
		double d = 0.1;
		boolean result = f2 == (float)d;
		
		System.out.println("c="+c);
		System.out.println("ch="+ch);
		System.out.println("f="+f);
		System.out.println("l="+l);
		System.out.println("result="+result);
		
				
	
		/*	다른 해법 시도의 흔적:
			float f_alt = (float)1.5;			// 성공
			long l_alt = (long)27000000000;		// 실패
			System.out.println(f_alt);
			
			float f2_alt = 0.1f;
			double d_alt = 0.1;
			System.out.println(f2_alt);						// 0.1
			System.out.println(d_alt);						// 0.1
			boolean result_alt = (float)f2_alt == d_alt;	// 캐스팅 없이도 true인데 의도는?
			// 실수의 경우 소숫점 자리가 커지면서 오차가 생기는 부분 때문에 false가 나올수는 있을 듯 한데
			// double float 비교 시 오차로 false 발생 가능성 있을듯, 그런데 위 상황은 그런 상황이 아닌듯?
		/*
		

		/*
		 	c=30
			ch=C
			f=1.5
			l=27000000000
			result=true
			
			* byte: 앞 문제에서도 봤듯 Java에서는 작은 데이터 타입(byte, short, char)으로 연산을 수행할 시
			int로 바뀝니다. int가 된 상황에서 byte로 들어가기에는 사이즈가 크기에 다시 byte로 캐스팅 해주서야 합니다.
			
			* char: 마찬가지 상황입니다. 대문자 A를 C로 변환을 원하시는데 ASCII 값으로 2 큰 값이시기에 2를 
			더해주면 됩니다. 어차피 앞서 애기했던 이유로 int로 바뀌어 정수로 연산이 되고 결과값만 다시 char로
			캐스팅하면 됩니다.
			
			* 실수가 있으면 Java는 기본적으로 double로 보기에 뒤에 f를 추가하거나 (float)을 앞에 두어 강제로
			float을 캐스팅 하면 됩니다.
			
			* long의 경우 (long)으로 캐스팅은 되지 않고 큰 수 뒤에 L을 추가하면됩니다.
			 
			* 마지막은 float f2와 double d를 둘 다 둔 이유가 있었네요. 불리언으로 비교를 하도록 해서 
			둘다 float로 해서 참값을 얻습니다. (그런데 캐스팅 안해도 true인데, 의도가 있을까요?)
			실수의 경우 소숫점 자리가 커지면서 오차가 생기는 부분 때문에 false가 나올수는 있을 듯 한데
			double과 float 비교 시 오차로 false 발생 가능성 있을듯, 그런데 위 상황은 그런 상황이 아닌듯?
			
		 
		 */

	}

}
