package work.com.workshop13.solutions.work13.exam07;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Mobile> map = new HashMap<>();
        double sum = 0.0;

        // 1. 4개 Mobile 객체 생성
        Mobile m1 = new Mobile("LU6800", "Optimus 2X", 800000);
        Mobile m2 = new Mobile("SU6600", "Optimus Black", 900000);
        Mobile m3 = new Mobile("KU5700", "Optimus Big", 700000);
        Mobile m4 = new Mobile("SU7600", "Optimus Mach", 950000);

        // 2. map에 4개의 객체를 code를 키 값으로 넣는다. 
        map.put(m1.getCode(), m1);
        map.put(m2.getCode(), m2);
        map.put(m3.getCode(), m3);
        map.put(m4.getCode(), m4);

        // 3. Mobile 정보를 출력 하고 합계를 계산 
        for (String key : map.keySet()) {
            Mobile m = map.get(key);
            System.out.println(m.printInfo());
            sum += m.getPrice();
        }

        System.out.println("합계 : " + sum);

        // 4. Mobile 객체의 가격 정보를 10% 증가 시킨다.
        for (Mobile m : map.values()) {
            double updatedPrice = m.getPrice() * 1.1;
            m.setPrice(updatedPrice);
        }

        // 5. 변경된 정보를 출력하고 합계를 계산한다. 
        System.out.println("\n가격 변경 후");
        double sum2 = 0.0;

        for (String key : map.keySet()) {
            Mobile m = map.get(key);
            System.out.println(m.printInfo());
            sum2 += m.getPrice();
        }

        System.out.printf("합계 :%10.1f " , sum2);
    }
}

