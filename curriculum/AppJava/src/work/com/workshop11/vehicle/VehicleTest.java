package work.com.workshop11.vehicle;

public class VehicleTest {

	public static void main(String[] args) {
		
		Truck car = new Truck(1000, 100, 5);
		
		System.out.printf("%6s\t%6s  %5s  %6s  %2s\n","최대적재중량", "오일탱크크기", "잔여오일량", "현재적재중량", "연비");
		System.out.println(("==================================================="));
		System.out.println(car.toString());

		// 50L 주유 후
		car.addOil(50);
		System.out.println(car.toString());
		
		// 50km 주행 후
		car.moving(50);
		System.out.println(car.toString());
		
		// 100kg 적재 후
		car.addWeight(100);
		System.out.println(car.toString());
		
		// 30km 주행 후
		car.moving(30);
		System.out.println(car.toString());
		
		//100kg 적재 후 30kg 주행 시 요금
		System.out.printf("\n요금 : %d원\n", car.getCost(30));

	}
}
