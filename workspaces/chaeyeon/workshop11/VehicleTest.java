package work.com.workshop11;

public class VehicleTest {
	public static void main(String[] args) {
		Truck truck = new Truck(1000, 100, 5);

		System.out.printf("%5s %5s %5s %5s %5s", "최대적재중량", "오일탱크크기", "잔여오일량", "현재적재중량", "연비");
		System.out.println("\n====================================");

		System.out.println(truck);
		System.out.println("50L 주유 후");
		truck.addOil(50);
		System.out.println(truck);

		System.out.println("50Km 주행 후");
		truck.moving(50);
		System.out.println(truck);

		System.out.println("100Kg 적재 후");
		truck.addWeight(100);
		System.out.println(truck);

		System.out.println("30Km 주행 후");
		truck.moving(30);
		System.out.println(truck);

		System.out.println("요금 : " + truck.getCost(30) + "원");
	}
}
