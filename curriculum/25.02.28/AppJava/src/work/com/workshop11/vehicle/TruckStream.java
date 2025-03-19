package work.com.workshop11.vehicle;

import java.util.ArrayList;
import java.util.List;

public class TruckStream {

	public static void main(String[] args) {
		Truck truck = new Truck(1000, 100, 5);
		
		String header = String.format("%6s\t%6s  %5s  %6s  %2s\n"
				+ "===================================================\n","최대적재중량", "오일탱크크기", "잔여오일량", "현재적재중량", "연비");
		System.out.println(header);
		System.out.println(truck.toString());
		
		List<String> logs = new ArrayList<>();
		
		
		
		// 50L 주유 후
		truck.addOil(50);
		logs.add(truck.toString());
		
		
		// 50km 주행 후
		truck.moving(50);
		logs.add(truck.toString());
		
		// 100kg 적재 후
		truck.addWeight(100);
		logs.add(truck.toString());
		
		// 30km 주행 후
		truck.moving(30);
		logs.add(truck.toString());
		
		// 로그를 Stream AP 활용해 출력 
		System.out.printf("\n로그 출력\n");
		logs.stream().forEach(System.out::println);
		
		// List<Integer> distanceList = List.of(30,30,50)으로 주어진 주행거리 목록을
		// truck.getCost(int distance) 메서드를 사용해 거리별 요금 계산 후 총합 출력
		List<Integer> distanceList = List.of(30,30,50);
		
		int totalCost = distanceList.stream()
							.mapToInt(truck::getCost)
							.sum();
		System.out.println("총 요금: " + totalCost + "원");
		


	}

}
