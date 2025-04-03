package work.com.workshop13.com.mobile;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		
		Map<String, Mobile> map = new HashMap<String, Mobile>();
		double sum = 0.0;
		
		// 4개의 Mobile 객체 생성
		Mobile phone1 = new Mobile("SU7600", "Optimus Mach", 950000.0);
		Mobile phone2 = new Mobile("KU5700", "Optimus Big", 700000.0);
		Mobile phone3 = new Mobile("SU6600", "Optimus Black", 900000.0);
		Mobile phone4 = new Mobile("LU6800", "Optimus 2X", 800000.0);
		
		// map에 4개의 객체를 code를 키 값으로 넣는다.
		// key : value pair = [String Code : (String Code, String name, double price)] 
		map.put(phone1.getCode(), phone1);
		map.put(phone2.getCode(), phone2);
		map.put(phone3.getCode(), phone3);
		map.put(phone4.getCode(), phone4);
		
		// Mobile 정보를 출력 하고 합계를 계산
		
		printAndSum(map);
		
		
		// Mobile 객체의 가격 정보를 10% 증가 시킨다.
		for(String phone : map.keySet()){
			map.get(phone).setPrice(map.get(phone).getPrice() * 1.1);
		}
		
		// 변경된 정보를 출력 하고 합계를 계산
		System.out.println("가격 변경 후");
		printAndSum(map);
		

	}

	private static void printAndSum(Map<String, Mobile> map) {
		
		double total = 0;
		
		// keyset는 key를 String으로 반환
		for(String phone : map.keySet()){
			System.out.println(map.get(phone).printInfo());
			total += map.get(phone).getPrice();
		}
		System.out.printf("합계 : %.1f\n", total);
		System.out.println();
		
	}

}
