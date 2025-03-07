package work.com.workshop3;

public class Test05 {

	public static void main(String[] args) {
		
		int sum = 0; // 주사위 3개의 총합 
		
		for (int i = 1; i <= 6; i++) {	// 첫 주사위 
			for (int j = 1; j <= 6; j++) { // 두번째 주사위 
				for (int k = 1; k <= 6; k++) { // 세번째 주사위 
					sum = i * j * k;			// 주사위 3개의 합이
					if (sum % 3 == 0) {			// 3의 배수인 경우 
						System.out.printf("%2d *%2d *%2d = %2d\n", i ,j, k, sum);
					}
					
				}
			}
		}

	}

}
