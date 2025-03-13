package work.com.workshop7.com.elite.test04;

public class Calc {
	public static double getSum(int data) throws InvalidException {
		
		if (data < 2 || data > 5) {
			throw new InvalidException("입력 값에 오류가 있습니다.");
		}		
		double sum = 0;
		
		for (int i = 1; i <= data; i++) {
			sum += (double) i;
		}
		
		return sum;
	} // end of getSum
} // end of Calc


	

