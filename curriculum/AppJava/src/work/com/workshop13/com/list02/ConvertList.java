package work.com.workshop13.com.list02;

import java.util.ArrayList;

// 배열을 Argument로 받아 ArrayList를 만들어 리턴 한다.

public class ConvertList {

	public ArrayList<Integer> convertList(int[] array) {
		// ArrayList 객체 선언
		ArrayList<Integer> list = new ArrayList<>();
		
		// 받은 배열을 반대로 선언한 객체에 입력
		for (int i = (array.length - 1); i >= 0; i--) {
			list.add(array[i]);
		}
		
		// 객체를 리턴
		return list;
	}
	
}
