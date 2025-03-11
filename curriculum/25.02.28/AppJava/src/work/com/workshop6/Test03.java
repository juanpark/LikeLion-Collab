package work.com.workshop6;

public class Test03 {

	public static void main(String[] args) {
		
		if (args.length == 0 || args[0].isEmpty()) {
			System.out.println("ERROR");
			return;
		}
		
		int number = Integer.parseInt(args[0]);
		int total = 0;
		
		boolean flag = false;	// 첫 수 앞에는 "+"를 넣지 않기 위한 플래그
		
		for (int i = number; i <= 10; i++) {
			
			if ((i % 3) == 0 || (i % 5) == 0) {
				continue;
			} else {
				if (flag == true) {	// 플래그가 참이 되는 시점부터 "+" 추가
					System.out.print(" + ");
				}
				System.out.print(i);
				total += i;
				flag = true;	// 첫 연산 이후로는 플래그가 참
			}
			
			
		}
		System.out.println();
		System.out.println("결과 : " + total);
	}

}
