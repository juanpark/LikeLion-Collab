package work.com.workshop13.com.elite;

import java.util.ArrayList;
import java.util.Random;

/*
	두 개의 ArrayList에 10개의 정수형 숫자(0~9까지)를 랜덤 하게 넣는다
	각각의 ArrayList에 숫자들을 이용하여 순서대로 나눗셈을 진행 한다.
*/

public class ListTest03 {

	public static void main(String[] args) {
		// 두 개의 ArrayList에 10개의 정수형 숫자(0~9까지)를 랜덤 하게 넣는다
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		Random rand = new Random();
		
		for (int i = 0; i < 10; i++) {
			list1.add(rand.nextInt(10));
			list2.add(rand.nextInt(10));
		}
		
		// print header
		System.out.printf("%s\t%s\t%s\n", "첫번째 ArrayList", "두번째 ArrayList", "결과");
		
		// 분모가 0이면 Exception 처리를 하라는 조건이 있는데 아래 정도면 충분? 아니면 try...catch... 활용?
		// 일단 아래는 삼항연산자를 활용하여 Exception 처리...
		// ArrayList의 경우 일반 배열과 달리 [i]로 인덱스를 활용 못하기에 .get(i)를 활용함
		for (int i = 0; i < 10; i++) {
			System.out.println("       " + list1.get(i) + " --------------" + list2.get(i) + "         "
								+  (list2.get(i) == 0 ? "분모가0입니다" : (list1.get(i)/list2.get(i))));
		}
	}

}
