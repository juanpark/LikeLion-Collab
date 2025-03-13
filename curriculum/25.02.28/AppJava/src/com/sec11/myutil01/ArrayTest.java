package com.sec11.myutil01;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayTest {

	public static void main(String[] args) {
		List<Integer> arr1 = new ArrayList<>();
		arr1.add(80);
		arr1.add(90);
		arr1.add(100);
		arr1.add(200);

		System.out.println(" for 문을 이용한 반복 ");
		for (int r : arr1) {
			System.out.printf("%5d", r);
		}
		
		arr1.remove(2);
		
		System.out.println("\n listIterator 문을 이용한 반복 ");

		ListIterator<Integer> res = arr1.listIterator();
		while (res.hasNext()) {
			System.out.printf("%5d", res.next());
		}
	}
}
