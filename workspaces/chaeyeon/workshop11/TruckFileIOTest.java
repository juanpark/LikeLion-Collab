package work.com.workshop11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TruckFileIOTest {
    public static void main(String[] args) throws IOException {
        Truck truck = new Truck(1000, 100, 5);

        truck.addOil(50);
        truck.moving(50);
        truck.addWeight(100);
        truck.moving(30);

        String truckState = truck.toString(); //현재 상태 문자열로 변환
        Files.writeString(Path.of("truck.txt"), truckState);

        String readState = Files.readString(Path.of("truck.txt"));
        System.out.println("파일에서 읽은 Truck 상태: \n" + readState);
    }
}
