package work.com.workshop3;

// 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오

public class Test03 {
	
	public static void main(String[] args) {
	
		int sum = 0; // 주사위 2개의 합
		
		for (int i = 1; i <= 6; i++) {		// 첫 주사위
			for (int j = 1; j <= 6; j++) {	// 두번째 주사위
				sum = i + j;				// 두 주사위의 합
				if (sum == 6) {				// 6과 같다면 다음을 프린트:
					System.out.printf("%d + %d = %d\n", i, j, sum);
				}
			}
		}
		
	}
	

}
