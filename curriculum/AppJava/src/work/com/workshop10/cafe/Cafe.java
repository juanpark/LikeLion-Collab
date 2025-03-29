package work.com.workshop10.cafe;

public class Cafe {
	private Coffee[] coffeeList;
	private int 	index;
	
	public Cafe () {
		// key to the problem! 이렇게 기본생성자 안에서 모두 initialize 하면 되는데!!! 
		this.coffeeList = new Coffee[3];
		this.index = 0;
	}
	
	public int totalPrice( ) {
		int total = 0;
		for (Coffee coffee : coffeeList) {
			total += coffee.getPrice();
		}
		return total;
	}
	
	public void setCoffee(Coffee coffee) {
		if (index < coffeeList.length) {
			coffeeList[index] = coffee;
			index ++;
		} else {
			System.out.println("더 이상 저장할 수 없습니다");
		}
		
	}
	
	public Coffee[] getCoffeeList() {
		return coffeeList;
	}
}
