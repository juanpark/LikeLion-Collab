package work.com.workshop11.vehicle;

public class Truck extends Car {

	public Truck() {
		// TODO Auto-generated constructor stub
	}

	public Truck(int maxWeight, double oilTankSize, double efficiency) {
		super(maxWeight, oilTankSize, efficiency);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getEfficiency() {
		return (super.getEfficiency() - ((getCarWeight() / 5) * 0.2));
	}
	
	@Override
	public void moving (int distance ) {
		System.out.printf("\n%skm 주행 후\n", distance );
		this.setRestOil(this.getRestOil() - calcOil(distance));	
	}
	
	private double calcOil (int distance) {
		return distance / this.getEfficiency();
	}	
	
	public int getCost (int distance) {
		return ((int)calcOil(distance) * 3000);
	}

	@Override
	public String toString() {
		return String.format("%s     %s", super.toString(), getEfficiency());
		//return String.format("%s", super.toString());
	}
	
	
}
