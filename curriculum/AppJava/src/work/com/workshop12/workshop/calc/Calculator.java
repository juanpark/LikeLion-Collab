package work.com.workshop12.workshop.calc;

public class Calculator {
	
	public double plus(int a, int b) {
		
		return a + b;
	}
	
	public double minus(int a, int b) {
		
		return a - b;
	}
	
	public double multiplication(int a, int b) {
		
		return a * b;
	}
	
	public double divide(int a, int b) {
		
		if (b == 0) {
			System.out.println("Exception 이 발생 하였습니다. 다시 입력해 주세요");
			return 0.0;
		} else {		
			return (double)a / b;	
		}	
	}
}
