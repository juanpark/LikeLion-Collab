package work.com.workshop7.com.elite.test05;

import java.util.HashMap;
import java.util.Random;

public class HashMapTest{
	public static void main(String args[]) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		double sum=0.0;
		
		Random rand = new Random();
		
		for (int i = 1; i <= 10; i++) {
			// HashMap에 1~100까지의 정수를 랜덤하게 10개 저장한다.
			map.put(i, rand.nextInt(100) + 1);		
		}
	
		for (int value : map.values()) {
			// HashMap 데이터를 화면에 출력한다.
			System.out.print(value + " ");	
			// HashMap 데이터의 합계를 계산한다.
			sum += value;			
		}
		System.out.println();

		
		// 합계와 평균을 화면에 출력한다.
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (sum / map.size()));
	}
}