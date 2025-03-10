package work.com.workshop4;

public class Work4_2 {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		int total = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			if (i % 2 != 0) {	// i & 1 = 
				total += arr[i];
			}
			
		}
		
		System.out.println("sum=" + total);

	}

}
