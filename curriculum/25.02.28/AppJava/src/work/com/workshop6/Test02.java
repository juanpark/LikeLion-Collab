package work.com.workshop6;

public class Test02 {

	public static void main(String[] args) {
		
		// args 입력확인
		if (args.length == 0 || args[0].isEmpty()) {
			System.out.println("ERROR");
			return;
		}
		
		int total = 0;
		
		// 구현 클래스 호출 
		total = Calc.calculate(Integer.parseInt(args[0]));
		
		System.out.println("결과: " +total);
	}
	
	public class Calc {
		
		static int calculate(int data) {
			
			int total = 0;
			
			System.out.print("짝수: ");
			for (int i = 1; i <= data; i++) {
				if ((i & 1) == 0) {		// 비트 연산으로 짝수 확인
					total += i;
					System.out.print(i + " ");
				}
			}
			System.out.println();
			
			return total;	
			
		}
	}

}
