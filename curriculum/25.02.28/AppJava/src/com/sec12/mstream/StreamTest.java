package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        // 1.리스트(List)에서 스트림 생성
        List<String> list = Arrays.asList("사원1", "사원2", "사원3", "사원4");
        Stream<String> streamFromList = list.stream();

        // 2️. 배열(Array)에서 스트림 생성
        String[] array = {"관리자1", "관리자2", "관리자3", "관리자4"};
        Stream<String> streamFromArray = Arrays.stream(array);

        // 3️. Stream.of()를 사용하여 스트림 생성 (개별 요소 지정)
        Stream<String> streamFromValues = Stream.of("1", "2", "3", "4", "5");

        // 4️. Stream.of()를 사용하여 배열을 스트림으로 변환
        Stream<String> streamFromArray2 = Stream.of(array);

        // 5️. 스트림 데이터 출력
        printStream("▶ 리스트 기반 스트림", streamFromList);
        printStream("▶ 배열 기반 스트림", streamFromArray);
        printStream("▶ Stream.of(개별 값)", streamFromValues);
        printStream("▶ Stream.of(배열 값)", streamFromArray2);
    }
   
    private static void printStream(String title, Stream<String> stream) {
        System.out.println(title);
        stream.forEach(e -> System.out.printf("%5s", e)); // 요소 출력
        System.out.println("\n============================\n");
    }
}
