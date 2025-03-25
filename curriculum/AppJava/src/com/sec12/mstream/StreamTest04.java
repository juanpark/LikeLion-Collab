package com.sec12.mstream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.IntStream;
public class StreamTest04 {

	public static void main(String[] args) {
		//Q1. 1~10까지 정수형 값을 스트림 생성 후 출력  map()을 사용해서 요소를 변환 -> String.valueof
		
        Stream<String> streamFromValues = IntStream.rangeClosed(1, 10).mapToObj(String::valueOf); 
        
        StreamTest.printStream("Q1. 1~10까지 정수형 값을 스트림 생성 후 출력", streamFromValues);
       
        //Q3. 10 ~ 1까지 정수형 값을 스트림 생성 후 출력 -> iterate 방법
        //역순으로 작성할 때는 iterate() 사용 -> rangeClosed는 step+1만 가능하기에
        
        Stream<String> streamFromValues03 = IntStream.iterate(10, i->i-1).limit(10).mapToObj(String::valueOf); //iterate는 한정값이 없기에 리미트를 줘야함    
        StreamTest.printStream("Q3. 10~1까지 정수형 값을 스트림 생성 후 출력", streamFromValues);
        
   
      //Q3-2. 10 ~ 1까지 정수형 값을 스트림 생성 후 출력 -> rangeClosed 방법
        streamFromValues03 = IntStream.rangeClosed(1, 10) // 1~10까지 정수 스트림
        									.map(i->11-i) // 역순으로 리턴
        									.mapToObj(String::valueOf); //문자열 변환 후 스트림 생성 후 리턴
        
        StreamTest.printStream("Q3-2. 10~1까지 정수형 값을 스트림 생성 후 출력", streamFromValues);
     
     
     //Q3-3. Stream<Interger> boxed() + sorted(Comparable.reversOrder())  -반드시 정렬이랑 같이 사용
        streamFromValues03 = IntStream.rangeClosed(1, 10)
        									.boxed() // boxing - 기본형 int -> Integer (sorted로 연산해야하기에)
        									.sorted((a, b)->b-a) //역순 내림차순
        									.map(String::valueOf); //문자열 변환 후 스트림 생성     
        
        StreamTest.printStream("Q3-3. 10~1까지 정수형 값을 스트림 생성 후 출력", streamFromValues);       

	}

}
