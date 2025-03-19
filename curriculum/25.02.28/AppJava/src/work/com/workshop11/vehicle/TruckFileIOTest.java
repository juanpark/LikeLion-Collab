package work.com.workshop11.vehicle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TruckFileIOTest {

	public static void main(String[] args) {
		
		Truck car = new Truck(1000, 100, 5);
		
		String header = String.format("%6s\t%6s  %5s  %6s  %2s\n"
				+ "===================================================\n","최대적재중량", "오일탱크크기", "잔여오일량", "현재적재중량", "연비");
		System.out.println(header);
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
		
		// Truck 상태 파일 저장 Files.writeString()
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("car.txt"));
			writer.write(header);
			writer.write(car.toString());
			writer.close();
			System.out.println("car.txt 저장 성공!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
		// 저장파일 읽기 Files.readString()
		try {
			BufferedReader reader = new BufferedReader(new FileReader("car.txt"));
			System.out.printf("파일에서 읽은 Truck 상태:\n");
			
			String line;
			while ((line = reader.readLine()) != null) {
			System.out.println(line);
			}
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
}

