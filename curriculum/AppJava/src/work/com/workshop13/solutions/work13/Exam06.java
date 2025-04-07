package work.com.workshop13.solutions.work13;

// eclipse argument로 10~20 사이 정수를 받아 리스트 크기로 사용하며, 출력 순서는 무시
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Exam06 {
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);

		if (size < 10 || size > 20) {
			System.out.println("크기는 10 이상 20 이하로 입력해야 합니다.");
			return;
		}

		ArrayList<Integer> list = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		Random rand = new Random();

		// ArrayList에 size만큼 랜덤 정수(1~10) 저장
		for (int i = 0; i < size; i++) {
			int num = rand.nextInt(10) + 1; // 1~10
			list.add(num);
		}

		// 출력: ArrayList
		System.out.println("ArrayList 출력:");
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println();

		// ArrayList 정보를 HashSet에 넣기
		for (int num : list) {
			set.add(num);
		}

		// 출력: HashSet (중복 제거된 값)
		System.out.println("HashSet 출력:");
		System.out.println(set); // 순서는 보장되지 않음
	}
}
