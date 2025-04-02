package work.com.workshop13.com.list01;

import java.util.Random;

import java.util.ArrayList;

public class MakeList {
	ArrayList<Integer> list;
	
	public MakeList() {
		// ArrayList 생성
		this.list = new ArrayList<>();
	}
	// ArrayList 생성
	public void makeArrayList(int size) {
		Random rand = new Random(); // 랜덤 숫자 생성 객체
		for (int i = 0; i < size; i++) {
			list.add(rand.nextInt(10) + 10);
		}
	}
	// ArrayList의 모든 값의 평균을 계산 하여 리턴
	public double getAverage() {
		int total = 0;
		for (int n : list) {
			total += n;
		}
		return (double)total / list.size();
	}
	// ArrayList를 리턴
	public ArrayList<Integer> getList() {
		return list;
		
	}
}
