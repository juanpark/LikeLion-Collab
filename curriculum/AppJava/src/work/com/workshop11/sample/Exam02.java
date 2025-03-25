package work.com.workshop11.sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Exam02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Truck truck = new Truck(1000, 100, 5);
        truck.addOil(50);
        truck.moving(50);
        truck.addWeight(100);
        truck.moving(30);

        // Truck 상태 파일 저장
        Path path = Path.of("truck_status.txt");
        Files.writeString(path, truck.toString());

        // 저장된 상태 읽기
        String result = Files.readString(path);
        System.out.println("파일에서 읽은 Truck 상태:");
        System.out.println(result);
	}

}
