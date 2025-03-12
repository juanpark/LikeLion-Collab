package work.com.workshop8.com.car;

public class CarTest {

	public static void main(String[] args) {
		// Car type의 객체 배열을 2개 만든다
		// 배열에 사용데이터에서 제공된 2개의 Car 객체를 넣는다.
		Car[] cars = new Car[2];
		cars[0] = new L3("L3", "1500", 50, 25, 0);
		cars[1] = new L5("L5", "2000", 70, 35, 0);

		// 생성된 자동차의 기본 정보 출력
		System.out.printf(
		"  %10s   %10s %10s  %10s  %10s  %10s\n", "vehicleName", "engineSize",
		"oilTank", "oilSize", "distance", "temperature");
		System.out.println("------------------------------------------------"
				+ "--------------------------");
		for (Car car : cars) {
			if (car instanceof Temp r) {
				System.out.printf(
				"%10s   %10s %10d  %10d  %10d  %10d\n", car.getName(), car.getEngine(),
				car.getOilTank(), car.getOilSize(), car.getDistance(), r.getTempGage());
			}
		}
				
		// 각각의 자동차에 25씩 주유 한다
		System.out.println();
		System.out.println("25 주유");
		// 25씩 주유한 자동차의 정보를 출력 한다				
		System.out.printf(
		"  %10s   %10s %10s  %10s  %10s  %10s\n", "vehicleName", "engineSize",
		"oilTank", "oilSize", "distance", "temperature");
		System.out.println("------------------------------------------------"
				+ "--------------------------");
		for (Car car : cars) {
			car.setOil(25);
			if (car instanceof Temp r) {
				System.out.printf(
				"%10s   %10s %10d  %10d  %10d  %10d\n", car.getName(), car.getEngine(),
				car.getOilTank(), car.getOilSize(), car.getDistance(), r.getTempGage());
			}
		}	
				

		// 각각의 자동차에 80씩 주행 한다
		// 80씩 주행한 정보를 출력 하며 엔진온도 정보를 출력 한다
		System.out.println();
		System.out.println("80 주행");
		
		System.out.printf(
		"  %10s   %10s %10s  %10s  %10s  %10s\n", "vehicleName", "engineSize",
		"oilTank", "oilSize", "distance", "temperature");
		System.out.println("------------------------------------------------"
				+ "--------------------------");
		for (Car car : cars) {
			car.go(80);
			if (car instanceof Temp r) {
				System.out.printf(
				"%10s   %10s %10d  %10d  %10d  %10d\n", car.getName(), car.getEngine(),
				car.getOilTank(), car.getOilSize(), car.getDistance(), r.getTempGage());
			}
		}	
	}

}

