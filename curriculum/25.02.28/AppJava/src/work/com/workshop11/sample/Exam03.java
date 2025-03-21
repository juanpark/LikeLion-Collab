package work.com.workshop11.sample;
import java.util.ArrayList;
import java.util.List;


public class Exam03 {

	public static void main(String[] args) {
		Truck truck = new Truck(1000, 100, 5);
        List<String> logs = new ArrayList<>();

        truck.addOil(50);                 // 1. 50L 주유
        logs.add(truck.toString());

        truck.moving(50);                 // 2. 50km 주행
        logs.add(truck.toString());

        truck.addWeight(100);             // 3.100kg 적재
        logs.add(truck.toString());

        truck.moving(30);                 // 4. 30km 주행
        logs.add(truck.toString());

      
        logs.stream().forEach(System.out::println);

      
        List<Integer> distanceList = List.of(30, 30, 50);
        int totalCost = distanceList.stream()
                                    .mapToInt(truck::getCost)
                                    .sum();

        
        System.out.println("총 요금: " + totalCost + "원");
	}

}
