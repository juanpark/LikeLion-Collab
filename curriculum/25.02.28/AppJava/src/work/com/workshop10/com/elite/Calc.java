package work.com.workshop10.com.elite;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calc {
	
	public static int calculate(int data) {
		// int 정수를 입력 받아 1부터 입력 받은 숫자까지 짝수의 합을 구하여 리턴
		
		List<Integer> numbers = IntStream.rangeClosed(1, data)
									.boxed() // primitive to Wrapper class object
									.collect(Collectors.toList());
									// stream 파이프라인의 마지막으로 stream을 list로 변환
		
		System.out.println("1부터 " + data + "까지의 숫자:");
		numbers.stream().forEach(e -> System.out.print(e + " "));

		System.out.println();
		System.out.println();
		System.out.println("짝수 판별:");
		numbers.stream().forEach(e -> System.out.print(e % 2 != 0 ? e + " (홀수) " : e + " (짝수) "));
		
		System.out.println();
		System.out.println();
		List<Integer> even = numbers.stream().filter(e -> e % 2 == 0).toList();
		System.out.println("입력 값: " + data);
		System.out.println("짝수 리스트: " + even);
		
		// IntSummaryStaticstics로 리스트의 sum, max, min, count를 한번에 처리!
		IntSummaryStatistics stats = even.stream()
				.mapToInt(Integer::intValue) // Integer -> int : calls intValue method on each Integer
				.summaryStatistics();
		
		System.out.println("짝수 개수: " + stats.getCount());
		System.out.println("짝수 중 가장 큰 값: " + stats.getMax());
		System.out.println("짝수 중 가장 작은 값: " + stats.getMin());
		// System.out.println("짝수의 합: " + stats.getSum());
		
		// stats.getSum()의 리턴 타이프는 long?
		return (int)stats.getSum();
	}
}
