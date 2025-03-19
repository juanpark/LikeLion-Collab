package work.com.workshop10.month;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Months {
	
	private static final Map<Integer, Integer> monthDays = Map.ofEntries( Map.entry(1, 31),
		 Map.entry(2, 28), Map.entry(3, 31), Map.entry(4, 30), Map.entry(5, 31),
		 Map.entry(6, 30), Map.entry(7, 31), Map.entry(8, 31), Map.entry(9, 30),
		 Map.entry(10, 31), Map.entry(11, 30), Map.entry(12, 31) );

	
	public static final void getDays(int months) {
		
		List <String> toPrint = Stream.of(months)
			.map(e -> String.format("%02d", e))
			.map(e -> List.of(
				"입력받은 월: " + e + "월",
				"짝수/홀수 여부: " + (Integer.parseInt(e) % 2 == 0 ? "짝수월" : "홀수월"),
				"마지막 일자: " + monthDays.getOrDefault(Integer.parseInt(e), 0) + "일"))
			.findFirst()
			.orElse(Collections.emptyList());
		
		
		System.out.println();
		System.out.println(toPrint);
	}
}

/*
 * 	10번의 문제 2번 푸시는 분들은 각 월의 마지막 날짜 찾기 
 * 	→ Map<Integer, Integer>monthDays.getOrDefault(month-1)을 만족하려면 Months 클래스의 멤버가 private static final
 * 	Map<Integer, Integer> monthDays = Map.ofEntries( Map.entry(1, 31),
 * 	Map.entry(2, 28), Map.entry(3, 31), Map.entry(4, 30), Map.entry(5, 31),
 * 	Map.entry(6, 30), Map.entry(7, 31), Map.entry(8, 31), Map.entry(9, 30),
 * 	Map.entry(10, 31), Map.entry(11, 30), Map.entry(12, 31) ); 로 선언되어야 합니다.
 */