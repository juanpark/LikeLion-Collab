package work.com.workshop12.workshop.calc;

public class CalcTest {

	public static void main(String[] args) {
		
		// input from args
		if (args.length != 3) {
			System.out.println("다시 입력 하세요");
			return;
		}
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[2]); 
		String operator = args[1];
		
		Calculator calc = new Calculator();
		
		Double result = switch (operator) {
			case "+" -> calc.plus(a, b);
			case "-" -> calc.minus(a, b);
			case "*" -> calc.multiplication(a, b);
			case "/" -> calc.divide(a, b);
			default -> throw new IllegalArgumentException("연산기호가 틀렸습니다.");
		};
		
		System.out.println("결과: " + result);
		
	}

}
