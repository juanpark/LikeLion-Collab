package work.com.workshop6;
import java.lang.reflect.Array;
import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
		
		// args가 비어 있는지?
		if (args.length == 0 || args[0].isEmpty()) {
			System.out.println("ERROR");
			return;
		// 또는 두개 보다 작거나 많은지
		} else if (args.length != 2) {
			System.out.println("다시 입력 하세요");
			return;
		// 또는 첫째 args가 1보다 작거나 5보다 큰지
		} else if (Integer.parseInt(args[0]) > 5 || Integer.parseInt(args[0]) < 1) {
			System.out.println("숫자를 확인 하세요");
			return;
		// 또는 둘째 args가 1보다 작거나 5보다 큰지
		} else if (Integer.parseInt(args[1]) > 5 || Integer.parseInt(args[1]) < 1) {
			System.out.println("숫자를 확인 하세요");
			return;
		}
		
		int row = Integer.parseInt(args[0]);
		int column = Integer.parseInt(args[1]);
		
		// [row][column] 크기의 배열 선언하기
		int [][] arr = new int[row][column];
		
		// 랜덤 값을 발생할 객체 만들기
		Random rand = new Random();
		
		int total = 0;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				
				arr[i][j] = rand.nextInt(5) + 1;  // 1~5 사이의 랜덤 값 배열에 넣기
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
		// 송치호님 아이디어: row * column = 배열크기
		
		

		
		
		
	}

}