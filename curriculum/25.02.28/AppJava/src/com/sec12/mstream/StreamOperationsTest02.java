package com.sec12.mstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperationsTest02 {

	public static void main(String[] args) {
		//Q1. 1~100까지 정수를 출력하자.
		
		Stream<String> streamFromValues = IntStream.rangeClosed(1, 100).mapToObj(String::valueOf);
		 StreamTest.printStream("1~100까지 정수를 출력하자.", streamFromValues);
		 
		 IntStream.rangeClosed(1, 100).forEach(e->System.out.printf("%5d", e));
		 
		
		//Q2. 위의 단계에서 짝수만 출력하자.
		//Arrays.stream(null)
		IntStream.rangeClosed(1, 100).filter(e -> e %2==0).forEach(e->System.out.printf("%d", e));
		System.out.println();
		
		IntStream.rangeClosed(1, 100).filter(e -> e %2!=0).forEach(e->System.out.printf("%d", e));		
		//Q3. 합을 구하자.
		System.out.println(IntStream.rangeClosed(1, 100).sum());
		 
		 
		//Q4. str을 문자열 리스트로 공백 기준으로 만들어서 5글자 이상인 단어만 필터링 후 모두 대문자로 출력하자.
	      System.out.println();
	      String str  ="Returns a composed Consumer that performs, in sequence, this operation followed by the after operation. If performing either operation throws an exception, it is relayed to the caller of the composed operation. If performing this operation throws an exception, the after operation will not be performed.";
	      Arrays.stream(str.split("\\s+")) // 공백 기준으로 문자열 나누기          
	          .filter(word -> word.length() >= 5) // 5글자 이상 필터링
	          .map(String::toUpperCase) // 대문자로 변환
	          .forEach(word -> System.out.printf("%15s", word)); // printf로 출력
		
		
	      System.out.println();
	      List<String> result   = Arrays.stream(str.split("\s+"))
	                              .filter(word -> word.length() >= 5) 
	                              .map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
	      System.out.println(result);
	      
	         System.out.println();
	      result   = Arrays.stream(str.split("\s+"))
	                              .filter(word -> word.length() >= 5) 
	                              .map(String::toUpperCase).collect(Collectors.toList());
	      System.out.println(result);

	}

}
