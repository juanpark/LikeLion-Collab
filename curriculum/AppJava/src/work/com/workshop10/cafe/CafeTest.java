package work.com.workshop10.cafe;

import java.util.Arrays;

public class CafeTest {

	public static void main(String[] args) {
		Cafe cafe = new Cafe();
		
		cafe.setCoffee(new Coffee("Americano", 4000));
		cafe.setCoffee(new Coffee("Caffelatee", 5000));
		cafe.setCoffee(new Coffee("Macchiato", 6000));
		
		// 굳이 forEach로? enhanced for문 써도 되는데? 연습인가?
		Arrays.asList(cafe.getCoffeeList())
				.forEach(coffee -> {
					System.out.println(coffee.toString());
				});
				
		System.out.println();
		System.out.println("Coffee 가격의 합: " + cafe.totalPrice());	
	}

}
