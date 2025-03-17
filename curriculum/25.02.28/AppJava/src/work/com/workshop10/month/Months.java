package work.com.workshop10.month;

public class Months {
	
	public int getDays(int months) {
		
		
		
		return 0;
	}
}

/*
 * 10번의 문제 2번 푸시는 분들은 각 월의 마지막 날짜 찾기 → Map<Integer, Integer>
 * monthDays.getOrDefault(month-1)을 만족하려면 Months 클래스의 멤버가 private static final
 * Map<Integer, Integer> monthDays = Map.ofEntries( Map.entry(1, 31),
 * Map.entry(2, 28), Map.entry(3, 31), Map.entry(4, 30), Map.entry(5, 31),
 * Map.entry(6, 30), Map.entry(7, 31), Map.entry(8, 31), Map.entry(9, 30),
 * Map.entry(10, 31), Map.entry(11, 30), Map.entry(12, 31) ); 로 선언되어야 합니다.
 */