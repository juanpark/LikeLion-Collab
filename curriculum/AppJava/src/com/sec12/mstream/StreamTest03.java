package com.sec12.mstream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest03 {

	public static void main(String[] args) {
		//Q1. 1~10까지 정수형 값을 스트림 생성 후 출력 map() : 요소 변환-> 정수를 문자열 변환 String.valueof
		Integer[] int_array = {1,2,3,4,5,6,7,8,9,10};
		
		//정수를 문자열로 변환
        Stream<String> streamFromValues = Arrays.stream(int_array).map(String::valueOf); //rapper클래스에 valueOf가 존재
        																				//map을 사용해서 요소를 변환
        StreamTest.printStream("Q1. 1~10까지 정수형 값을 스트림 생성 후 출력", streamFromValues);
        
		
        //Q2."import java.util.stream.Stream" 문자열을 잘라서 배열로 만든 후 스트림 생성 후 출력
        String[] stringArray = "import java.util.stream.Stream".split(" ");		
        Stream<String> stream2 = Arrays.stream(stringArray);
        StreamTest.printStream("\"import java.util.stream.Stream\" 문자열을 잘라서 배열로 만든 후 스트림 생성 후 출력", stream2);  
		
		
 
        //Q3. 10 ~ 1까지 정수형 값을 스트림 생성 후 출력
		Integer[] int_array02 = {10,9,8,7,6,5,4,3,2,1};
		
		//정수를 문자열로 변환
        Stream<String> streamFromValues3 = Arrays.stream(int_array02).map(String::valueOf);
        StreamTest.printStream("Q3. 1~10까지 정수형 값을 스트림 생성 후 출력", streamFromValues3);
       

	}

}
