package work.com.workshop7.com.elite.test07;

import java.util.HashMap;
import java.util.Map;

public class Company {

	public static void main(String[] args) {
		
		// 먼저 Employee 클래스 추상객체에 맞춰 후손 객체를 생성해주며 필드를 입력한다.
		Employee employee1 = new Secretary("Hilery", 1, "secretary", 800);
		Employee employee2 = new Sales("Clinten", 2, "sales", 1200);
		
		// 생성된 객체들을 해시멥에 넣는다.
		// 해시맵은 키, 값 쌍으로 보관하는 데이터구조이다.
		// 키는 객체의 number로 해주고 값으로는 객체 그 자체를 저장한다.
		
		//아래가 해시맵 작성 syntax이다. map 해시맵 객체를 만든다
		HashMap<Integer, Employee> map = new HashMap<>();
		
		// map 안에 employee 객체의 number를 키로, employee객체를 값으로 입력한다. 
		map.put(employee1.getNumber(), employee1);
		map.put(employee2.getNumber(), employee2);
		
		System.out.printf("%-10s  %10s %10s\n", "name", "department", "salary");
		System.out.println("----------------------------------");
		
		// map의 키 값으로 순회하면서 각 값 (객체) 내의 필드를 프린트한다.
		// 해시맵의 for문 syntax는 다음과 같다:
		for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
			// sysout에서 사용하기 위해 값의 필드를 임시 저장, 안 그럴 경우 너무 entry.getValue().getName() 형태로 너무 길어진다. 
			Employee temp = entry.getValue(); 
			System.out.printf("%-10s  %-10s     %-10s\n", temp.getName(), temp.getDepartment(), temp.getSalary());
		}
		
		System.out.println();
		System.out.println("인센티브 100 지급");
		System.out.println();
		
		System.out.printf("%-10s  %10s %10s      %-5s\n", "name", "department", "salary", "tax");
		System.out.println("------------------------------------------");
		
		// map의 키 값으로 순회하면서 각 값 (객체) 내의 인센티브 필드를 수정하고 세금을 포함하여 프린트 한다.
		// 인센티브 계산 및 세금 게산은 각각 클래스에서 모두 이루어진다.
		// 해시맵의 for문 syntax는 다음과 같다:
		for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
			// sysout에서 사용하기 위해 값의 필드를 임시 저장, 안 그럴 경우 너무 entry.getValue().getName() 형태로 너무 길어진다.
			Employee temp = entry.getValue();
			// incentive() 메서드는 클래스가 인터페이스에서 상속받아 객체를 선언한 추상 클래스와는 관계가 없음
			// 그래서 강사님이 추천한 형변환 (동적 바인딩)
			if (temp instanceof Bonus r) {
				r.incentive(100);
				// System.out.println("DEBUG");
			}
			 
			System.out.printf("%-10s  %-10s     %-10s  %-5.1f\n", temp.getName(), temp.getDepartment(), temp.getSalary(), temp.tax());
		}
		
	}
		
}

