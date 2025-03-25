package work.com.workshop4;

public class Work4_1 {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30, 40, 50};
		int total = 0;
		int avg = 0;
		
		// for-each loop
		for (int res : arr) {
			total += res;
		}
		
		avg = total / arr.length;
		
		System.out.println("sum=" + total);
		System.out.println("avg=" + avg);

	}

}
