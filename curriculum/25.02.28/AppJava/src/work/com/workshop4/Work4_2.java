package work.com.workshop4;

public class Work4_2 {

	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		int total = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			// 보통 사용하는 홀수 알고리즘
			/*
			if (i % 2 != 0) { 
				total += arr[i];
			}*/
			
			// 비트 연산으로 홀수를 파악하는 알고리즘
			// i 값의 비트 중 마지막자리 비트 1일 경우 1 AND 1 = 1는 홀수, 0일 경우 0 AND 1 = 0 짝수 
			// 0001 = 1, 0010 = 2, 0011 = 3, 0100 = 4, 0101 = 5, 0110 = 6, 0111 = 7
			// 위에서 보듯이 홀수는 마지막 비트가 항상 1이다.
			if ((i & 1) == 1) {	
				total += arr[i];
			}
			
		}
		
		System.out.println("sum=" + total);

	}

}
