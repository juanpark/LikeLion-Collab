package work.com.workshop8.workshop;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Test01 {

	public static void main(String[] args) {
		// 5개의 점수를 입력 받는다.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input five scores: ");
		String input = sc.nextLine();
		
		List<Double> inputs = new ArrayList<>();
		
		// 글자 사이 여백을 위한 regex는 \\s+ 사용하라고 합니다.
	    for (String s : input.split("\\s+")) {
            inputs.add(Double.parseDouble(s));
        }
				
		// 5개가 아니면 “다시 입력 하세요”라고 메시지를 출력 한다.
		int inputsLength = inputs.size();
		if (inputsLength != 5) {
			System.out.println("다시 입력 하세요");
			return;	
		} else {
			// 10부터 99가지의 값을 입력 받는다.
			//입력된 10부터 99까지의 정수가 아닌 경우 “다시 입력 하세요”라고 메시지를 출력 한다.
			for (double member : inputs) {
				if (member < 10 || member > 99) {
					System.out.println("다시 입력 하세요");
					return;	
				} // if end
			} // for loop end
		} // else end
		
/*		(A+B)/2 : 60%
		(C+D)/2 : 20%
		E : 20%
		90 이상이면: Gold Class
		80 이상이면: Silver Class
		70 이상이면: Bronze Class
		70 미만이면: Normal Class*/
		
		
		double total = 0.0;
		total += (((inputs.get(0) + inputs.get(1)) / 2) * 0.6); // (A + B / 2 : 60%
		total += (((inputs.get(2) + inputs.get(3)) / 2) * 0.2); // (C + D / 2 : 20%
		total += (inputs.get(4) * 0.2);							//  E		  : 20%
		
		// if-else는 식상하고 switch는 더블도 안되고 범위도 안되어 switch에 맞는 형태로 숫자를 변환하는 몸부림 
		// 그냥 if-else 푸는 것이 더 간단할듯;;
		int totalInt = ((int)total / 10);  
		String result = switch (totalInt) {
			case 10, 9 -> "Gold Class";
			case 8 -> "Silver Class";
			case 7 -> "Bronze Class";
			default -> "Normal Class";
		};
		
		System.out.println("평가점수: " + total + "점");
		System.out.println("Class: " + result);
		
		
		
		



	}

}
