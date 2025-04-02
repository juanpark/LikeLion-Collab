package work.com.workshop13.com.list01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ListTest01 {
	public static void main(String[] args) {
		
		// argument로 정수를 받는다.
		if (args == null || args.length == 0 || args[0] == null || args[0].isEmpty()) {
			System.out.println("Argument 입력 해주세요.");
			return;
		}
		
		int number = Integer.parseInt(args[0]);
		
		if (!(number >= 5 && number <= 10)) {
			System.out.println("Argument는 5~10 사이 정수 입니다.");
			return;
		}

		System.out.println(number);
		
		// MakeList 객체 생성
		MakeList ml = new MakeList();
		
		// 무작위의 번호 발생 후 저장
		ml.makeArrayList(number);
		
		// 굳이 왜 여기에서 로컬 어레이리스트 객체를 또 만들지?
		ArrayList<Integer> list = ml.getList();
		
		// for문을 이용하여 ArrayList의 정보 출력하고 평균을 출력 한다.
		for (int n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		// 평균 출력
		System.out.println("평균 : " + ml.getAverage());
	}
}
