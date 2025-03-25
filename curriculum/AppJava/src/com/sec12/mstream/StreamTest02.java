package com.sec12.mstream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class StreamTest02 {

	public static void main(String[] args) {
		//Q1. 1~10까지 정수형 값을 스트림 생성 후 출력
        Stream<String> streamFromValues = Stream.of("1", "2", "3", "4", "5");
        StreamTest.printStream("Q1. 1~10까지 정수형 값을 스트림 생성 후 출력", streamFromValues);
        //캐스팅이 많이 필요함
		
        
        //Q2."import java.util.stream.Stream" 문자열을 잘라서 배열로 만든 후 스트림 생성 후 출력
        String[] stringArray = "import java.util.stream.Stream".split(" ");		
        Stream<String> stream2 = Arrays.stream(stringArray);
        StreamTest.printStream("\"import java.util.stream.Stream\" 문자열을 잘라서 배열로 만든 후 스트림 생성 후 출력", stream2);  
		
		
        //Q3. 10 ~ 1까지 정수형 값을 스트림 생성 후 출력
		//.printStream(null, null);		 //추가하기!!
	}

}
