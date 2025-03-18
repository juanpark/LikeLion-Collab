package work.com.workshop10.month;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MonthsSample {
    // 각 월의 마지막 날짜를 저장하는 Map (Key: 월, Value: 마지막 날짜)
    private static final Map<Integer, Integer> monthDays = Map.ofEntries(
        Map.entry(1, 31), Map.entry(2, 28), Map.entry(3, 31), Map.entry(4, 30),
        Map.entry(5, 31), Map.entry(6, 30), Map.entry(7, 31), Map.entry(8, 31),
        Map.entry(9, 30), Map.entry(10, 31), Map.entry(11, 30), Map.entry(12, 31)
    );

    //  getDays()에서 getOrDefault()를 적용하여 기본값 처리
    public int getDays(int month) {
        return monthDays.getOrDefault(month, 0); // 입력된 월의 마지막 일자를 반환
    }
}

public class Exam_ClassSample {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("입력된 값이 잘못 되었습니다");
            return;
        }

        try {
            int month = Integer.parseInt(args[0]);

            // 1~12 사이의 숫자인지 검증 → IntStream 사용
            boolean isInvalidMonth = IntStream.rangeClosed(1, 12).noneMatch(n -> n == month);
            if (isInvalidMonth) {
                System.out.println("입력된 값이 잘못 되었습니다");
                return;
            }

            MonthsSample months = new MonthsSample();
         
            List<String> monthInfo = Stream.of(month)
                .map(m -> String.format("%02d", m))  
                .map(m -> List.of(
                    "입력받은 월: " + m + "월",
                    "짝수/홀수 여부: " + (Integer.parseInt(m) % 2 == 0 ? "짝수월" : "홀수월"),
                    "마지막 일자: " + months.getDays(Integer.parseInt(m)) + "일"
                ))
                .findFirst()
                .orElse(Collections.emptyList());
         
            System.out.println("월을 입력하세요 (1~12): " + month);
            monthInfo.forEach(System.out::println);

        } catch (NumberFormatException e) {
            System.out.println("입력된 값이 잘못 되었습니다");
        }
    }
}
