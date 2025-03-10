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
		
		double arrayNumber = arr2[0].length * arr2.length;
		
		
		
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
