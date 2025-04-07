package work.com.workshop13.solutions.work13.exam04;
import java.util.ArrayList;
import java.util.List;

public class ShipTest {
    public static void main(String[] args) {
        List<Ship> list = new ArrayList<>();

        // 객체 생성 및 ArrayList에 저장
        list.add(new Boat("Boat01", 500));
        list.add(new Cruise("Cruise01", 1000));

        // 생성된 객체 정보 출력    
        printList(list);

        // 각 객체에 10만큼 운항
        for (Ship s : list) {
            s.sail(10);
        }

        System.out.println("\n10 운항 후");
        printList(list);

        // 각 객체에 50만큼 주유
        for (Ship s : list) {
            s.refuel(50);
        }

        System.out.println("\n50 주유 후");
        printList(list);
    }

    // 공통 출력 함수
    public static void printList(List<Ship> list) {
    	System.out.println(String.format("%-10s %-10s", "shipName", "fuelTank"));
        System.out.println("-----------------------------");
        list.stream()
            .map(s -> String.format("%-10s %-10d", s.getShipName(), s.getFuelTank()))
            .forEach(System.out::println);
    }
}
