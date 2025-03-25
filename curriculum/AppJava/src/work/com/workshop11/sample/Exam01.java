package work.com.workshop11.sample;

public class Exam01 {

	public static void main(String[] args) {
		Truck truck = new Truck(1000, 100, 5); // 최대적재 1000kg, 오일탱크 100L, 기본연비 5km/L

		printHeader();
		System.out.println(truck.toString()); // 초기 출력

		truck.addOil(50); // 50L 주유
		System.out.println(truck.toString());

		truck.moving(50); // 50km 주행
		System.out.println(truck.toString());

		truck.addWeight(100); // 100kg 적재
		System.out.println(truck.toString());

		truck.moving(30); // 30km 주행
		System.out.println(truck.toString());

		// 요금 출력 (100kg 싣고 30km 주행)
		int cost = truck.getCost(30);
		System.out.println("요금 : " + cost + "원");
	}

	static void printHeader() {
		System.out.println("최대적재중량\t오일탱크크기\t잔여오일량\t현재적재중량\t연비");
		System.out.println("==========================================================");
	}

}
