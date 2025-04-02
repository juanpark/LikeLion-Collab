package work.com.workshop13.com.elite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/*
eclipse argument로 정수형 데이터를 10~20까지 받아 들여 입력 받은 사이즈만큼 ArrayList에
1~10까지 랜덤 하게 만들어서 저장 한 후 결과를 출력 한다.
ArrayList의 모든 정보를 Hashset에 저장 한 후 결과를 출력 하는 프로그램을 작성 한다.
(출력 순서는 무시 한다.)
*/
public class ListHashSet {
	public static void main(String[] args) {
		// args 입력값 검증 및 변수에 입력
		int size = 0;
		if (args == null || args.length == 0 || args[0] == null || args[0].isEmpty()) {
			System.out.println("Argument를 입력 해주세요.");
			return;
		} else {
			size = Integer.parseInt(args[0]);
			if (size < 10 || size > 20) {
				System.out.println("정수를 10~20 사이에서 입력 해주세요.");
				return;
			}
		}
		
		// ArrayList 객체 생성
		ArrayList<Integer> list = new ArrayList<>();
		// HashSet 객체 생성
		HashSet<Integer> set = new HashSet<Integer>();
		
		// Random 숫자 생성을 위한 객체 생성
		Random rand = new Random();
		
		// ArrayList에 랜덤 숫자 입력
		for (int i = 0; i < size; i++) {
			list.add(rand.nextInt(10) + 1);
		}
		// HashSet에 ArrayList 입력
		set.addAll(list);
		
		// ArrayList 출력
		for (int n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		// HashSet 출력
		System.out.println(set.toString());
		
		

	}

}
