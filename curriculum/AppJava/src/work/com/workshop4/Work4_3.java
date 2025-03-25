package work.com.workshop4;

public class Work4_3 {

	public static void main(String[] args) {
		
		int[][] arr2 = {
				{ 5, 5, 5, 5, 5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
				};
		
		int total = 0;
		double avg = 0;
		
		// 다차원 배열 크기 파악하기 = 
		// arr2.length = 5 (행의 개수)
		// arr2[0].length = 4 (행 0의 개수 즉 열의 개수)
		// 행의 개수 * 열의 개수
		double arrayNumber = arr2.length * arr2[0].length; 
		
		
		for (int[] row : arr2) {
			for (int res : row) {
				total += res;
			}
		}

		avg = total / arrayNumber;
		
		System.out.println("total=" + total);
		System.out.printf("average=%.2f", avg);
	}

}
