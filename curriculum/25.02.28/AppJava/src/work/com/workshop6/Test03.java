package work.com.workshop6;

public class Test03 {

	public static void main(String[] args) {
		
		if (args.length == 0 || args[0].isEmpty()) {
			System.out.println("ERROR");
			return;
		}
		
		int number = Integer.parseInt(args[0]);
		int total = 0;
		
		for (int i = number; i <= 10; i++) {
			if ((i % 3) == 0 || (i % 5) == 0) {
				continue;
			} else {
				System.out.print(i);
				total += i;
			}
			System.out.print(" + ");
		}
		System.out.println();
		System.out.println("결과 : " + total);
	}

}
