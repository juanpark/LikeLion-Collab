package work.com.workshop11.vehicle;

public class Car extends Vehicle {
	
	private double		restOil;
	private int		carWeight;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(int maxWeight, double oilTankSize, double efficiency) {
		super(maxWeight, oilTankSize, efficiency);
		// TODO Auto-generated constructor stub
	}
	
	public double getRestOil() {
		return restOil;
	}
	public void setRestOil(double restOil) {
		this.restOil = restOil;
	}
	public int getCarWeight() {
		return carWeight;
	}
	public void setCarWeight(int carWeight) {
		this.carWeight = carWeight;
	}
	
	public void addOil (int oil) {
		// 현재 기름양 + 투입 기름양의 합계가 오일탱크 크기보다 크다면 경고 메시지 후 투입 안함
		if ((this.getRestOil() + oil) > this.getOilTankSize()) {
			System.out.println("오일탱크크기 초과");
		} else {
			System.out.printf("\n%sL 주유 후\n", oil );
			this.setRestOil(this.getRestOil() + oil);
		}
	}
	
	public void moving (int distance) {
		// 구현안함
	}
	
	public void addWeight (int weight) {
		// 현재 적쟁중량 + 투입 중량의 합계가 최대적재중량 보다 크다면 경고 메시지 후 적재 안함
		if (this.getCarWeight() + weight > this.getMaxWeight()) {
			System.out.println("최대적재중량 초과");
		} else {
			System.out.printf("\n%skg 적재 후\n", weight );
			this.setCarWeight(this.getCarWeight() + weight);
		}
	}
	@Override
	public String toString() {
		return String.format("%s     %-6s   %-6s", super.toString(), restOil, carWeight);
	}
	
	
	
	
	
	
	

}
