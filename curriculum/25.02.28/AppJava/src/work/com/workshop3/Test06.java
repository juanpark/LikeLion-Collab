package work.com.workshop3;

/*이클립스에서 명령문에서 (터미널에서) args를 입력 받고 싶다면
Run > Run configurations... > Arguments 탭 > Program Arguments에 입력 후 Run*/

public class Test06 {
	public static void main(String[] args) {
		
		int input = 0;
		
		// eclipse에서 입력받은 args가 있다면.
		if (args.length > 0) {
			input = Integer.parseInt(args[0]); // 스트링을 정수로.
		} else {
			return; // 없다면 프로그램 나오기.
		}
		
		// 1부터 100까지 더하는 프로그램 작성. 
		// 이클립스에서 argument로 1자리 정수형 데이터 입력 받아 입력 받은 수의 배수만 더한다.
		int sum = 0; // 입력 받은 수의 배수만 더할 변수.
		
		for (int i = 1; i <= 100; i++) {
			if (i % input == 0) { // 입력 받은 수의 배수인지 확인
				sum = sum + i;
			}
		}
		
		System.out.println(sum);
		
		
	}
}
