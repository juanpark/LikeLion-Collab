package work.com.workshop13.com.list02;

import java.util.ArrayList;

/*
다음에 주어진 배열을 ArrayList에 넣고 ArrayList의 내용을 출력 하는 프로그램을 작성 하시오.
ArrayList에 값을 넣을 때는 배열의 뒤에서부터 넣는다.
*/


public class ListTest02 {

	public static void main(String[] args) {
		// ArrayList에 넣을 배열
		int array[] = {3,4,2,5,2,3,6,7,5,7,9};
		
		// 배열을 ArrayList에 넣기위해 만들어진 객체를 만든다
		ConvertList convert = new ConvertList();
		
		// convert 객체에서 array 배열을 받아 거꾸로 ArrayList에 넣고
		// 그 ArrayList 객체를 다시 main에 선언된 ArrayList로 리턴한다.
		ArrayList<Integer> list = convert.convertList(array);
		
		// 받은 ArrayList객체 출력 
		for (int n : list) {
			System.out.println(n);
		}
		
		
	}

}
