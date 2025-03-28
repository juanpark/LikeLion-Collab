package work.com.workshop12.solutions;

import java.util.List;

public class Exam03 {
    public static void main(String[] args) {
        List<String> names = List.of("Tom", "Jerry", "Mike", "James", "Anna", "Sue");

        names.stream()
                .filter(name -> name.length() >= 4)    // 이름 길이 4 이상 필터링
                .sorted()                             // 알파벳 순 정렬
                .forEach(System.out::println);        // 출력
    }
}
