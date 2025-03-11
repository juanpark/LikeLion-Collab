package work.com.workshop6;

public class Test01 {
	
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		
		// 인덱스를 0부터 9가 아니 반대로 9부터 0으로 내림차순으로 인덱싱 해야 함
		// 배열의 길이가 10, 10 - 9로 9부터 시작
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}
}
