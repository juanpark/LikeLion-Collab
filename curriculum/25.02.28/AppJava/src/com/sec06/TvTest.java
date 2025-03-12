package com.sec06;

public class TvTest {
	public static void main(String[] args) {
//		Tv tv1 = new Tv("INFINIA", 1500000,"LED TV");
//		Tv tv2 = new Tv("XCANVAS",1000000,"LCD TV");
//		Tv tv3 = new Tv("CINEMA",2000000,"3D TV");
	

		//case 1 :각 객체 생성된 주소를 배열에 담아서 처리 
		//Tv[] tvs = { tv1, tv2, tv3 };

		//case 2:  초기값 전달 하면서 배열에 담아서 처리 		
		Tv[] tvs = new Tv[] {
				new Tv("INFINIA", 1500000,"LED TV"),
				new Tv("XCANVAS",1000000,"LCD TV"),
				new Tv("CINEMA",2000000,"3D TV")				
		};		
		
		// case 3: 동적메모리 확보 후 값 대입  
		tvs = new Tv[3];
		tvs[0]=	new Tv("INFINIA", 1500000,"LED TV");
		tvs[1]=	new Tv("XCANVAS",1000000,"LCD TV");
		tvs[2]=	new Tv("CINEMA",2000000,"3D TV");				
		
		
		
		for (Tv tv : tvs) {
			System.out.println(tv);
		}

		int maxPrice = tvs[0].getPrice();
		for (int i = 0; i < tvs.length; i++) {
			if (tvs[i].getPrice() > maxPrice) {
				maxPrice = i;
			}
		}
		System.out.println("가격이 가장 비싼 제품: " + tvs[maxPrice].getName());

		int minPrice = tvs[0].getPrice();
		for (int i = 0; i < tvs.length; i++) {
			if (tvs[i].getPrice() < minPrice) {
				minPrice = i;
			}
		}
		System.out.println("가격이 가장 저렴한 제품: " + tvs[minPrice].getName());

	}
}
