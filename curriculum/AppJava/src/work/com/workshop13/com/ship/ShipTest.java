package work.com.workshop13.com.ship;

import java.util.ArrayList;

public class ShipTest {
	public static void main(String[] args) {
		
		// ArrayList를 만들어 각각의 Boat 객체 와 Cruise객체 를 생성 하여 넣는다
		ArrayList<Ship> list = new ArrayList<>();
		
		Ship boat = new Boat("Boat01", 500);
		Ship cruise = new Cruise("Cruise01", 1000);
		list.add(boat);
		list.add(cruise);
		
		// 생성된 객체의 정보 출력 - for문 사용
		
		// 출력 헤더 만들기
		String header = String.format(
				"  %-10s\t %-10s\n"
				+ "-----------------------------\n", 
				"shipName", "fuelTank");		
		System.out.print(header);
		for (Ship ship : list) {
			System.out.printf("   %-8s\t   %-8s\n", ship.getShipName(), ship.getFuelTank());
		}
		
		// 각각의 Ship 객체에 10 운항 후 객체 정보 출력 - for 문 사용
		for (Ship ship : list) {
			ship.sail(10);
		}
		System.out.println("\n10 운항");
		System.out.print(header);
		for (Ship ship : list) {
			System.out.printf("   %-8s\t   %-8s\n", ship.getShipName(), ship.getFuelTank());
		}
		
		//각각의 Ship 객체에 50 주유 후 객체 정보 출력 – for문 사용
		for (Ship ship : list) {
			ship.refuel(50);;
		}
		System.out.println("\n50 주유");
		System.out.print(header);
		for (Ship ship : list) {
			System.out.printf("   %-8s\t   %-8s\n", ship.getShipName(), ship.getFuelTank());
		}

	}

}
