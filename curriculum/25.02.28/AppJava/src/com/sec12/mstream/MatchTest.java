package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MatchTest {

	public static void main(String[] args) {	
		
		List<String> str = Arrays.asList("딸기", "바나", "멜론", "수박");

		System.out.println(str.stream().anyMatch(s -> s.equals("멜론")));
		System.out.println(str.stream().noneMatch(s -> s.equals("스낵")));
		System.out.println(str.stream().allMatch(s -> s.length() == 3));
      
		IntStream i = IntStream.of(1, 2, 3, 4, 5);
		int[] v = i.toArray();
		for (int n : v) {
			System.out.printf("%3d",n);
		}
		System.out.println("\ncount : " + IntStream.of(1, 2, 3, 4, 5).count());
		System.out.println("sum :" + IntStream.of(1, 2, 3, 4, 5).sum());
		System.out.println("avg : " + IntStream.of(1, 2, 3, 4, 5).average());
 
	}
	
	public static void Exam() {
		/*
		Q1: allMatch() 메서드를 사용하여 리스트의 모든 요소가 "나"를 포함하는지 확인.
		 List<String> fruits = Arrays.asList("바나나", "파인애플", "망고", "체리");
		 
		Q2: IntStream.rangeClosed(1, 10)으로 1부터 10까지 생성 후 짝수만 필터링(filter())하여 출력, 합계를 구함.
		Q3: IntStream.of(1,2,3,4,5).average()의 결과를 orElse(0.0)을 사용하여 OptionalDouble의 값을 3.0으로 출력.
		Q4: sorted()를 사용하여 문자열 리스트를 정렬 후 출력.
		 List<String> names = Arrays.asList("홍길동", "김철수", "이영희", "박영수");
		*/

	}
}
