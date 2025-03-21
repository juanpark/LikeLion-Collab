package work.com.workshop11.sample;

import java.util.List;

public class Exam04 {

	public static void main(String[] args) {
		List<Integer> distanceList = List.of(30, 30, 50);
		List<Double> efficiencySnapshots = List.of(1.0, 1.0, 5.0);  // 당시 연비 상태 저장

		int totalCost = 0;
		for (int i = 0; i < distanceList.size(); i++) {
		    int distance = distanceList.get(i);
		    double efficiency = efficiencySnapshots.get(i);
		    double usedOil = distance / efficiency;
		    totalCost += (int) (usedOil * 3000);
		}
		System.out.println("총 요금: " + totalCost + "원");

	}

}
