package work.com.workshop4.calculator;

public class Test04 {

	public static void main(String[] args) {
		
		int[] arr = new int[4];
		
		for (int i = 0; i < args.length; i++) {
			arr[i] = Integer.parseInt(args[i]);
		}
		
		int total = 0;
		double avg = 0.0;
		
		total = Calc.calcSum(arr[0], arr[1], arr[2], arr[3]);
		
		
		avg = (double)total / arr.length;
		
		System.out.println("Sum:" + total);
		System.out.println("Avg:" + avg);
		
		if (avg >= 90 && avg <= 100) {
			System.out.println("A학점");
		} else if (avg >= 70 && avg < 90) {
			System.out.println("B학점");
		} else if (avg >= 50 && avg < 70) {
			System.out.println("C학점");
		} else if (avg >= 30 && avg < 50) {
			System.out.println("D학점");
		} else {
			System.out.println("F학점");
		}
		
	}

}
