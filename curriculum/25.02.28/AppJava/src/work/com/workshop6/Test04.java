package work.com.workshop6;
import java.lang.reflect.Array;
import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
		
		if (args.length == 0 || args[0].isEmpty()) {
			System.out.println("ERROR");
			return;
		} else if (args.length != 2) {
			System.out.println("다시 입력 하세요");
			return;
		} else if (Integer.parseInt(args[0]) > 5 || Integer.parseInt(args[0]) < 1) {
			System.out.println("숫자를 확인 하세요");
			return;
		} else if (Integer.parseInt(args[1]) > 5 || Integer.parseInt(args[1]) < 1) {
			System.out.println("숫자를 확인 하세요");
			return;
		}
		
		int row = Integer.parseInt(args[0]);
		int column = Integer.parseInt(args[1]);
		
		int [][] arr = new int[row][column];
		
		Random rand = new Random();
		
		int total = 0;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				
				arr[i][j] = rand.nextInt(5) + 1;  // generates a number from 1~5
				total += arr[i][j]; 
			}
		}
		
		for (int[] line : arr) {
			for (int num : line) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
		System.out.printf("\nsum=%.2f", (double)total );
		System.out.printf("\navg=%.2f\n", (double)total / (row * column));
		
		

		
		
		
	}

}