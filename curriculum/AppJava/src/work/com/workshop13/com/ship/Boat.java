package work.com.workshop13.com.ship;

public class Boat extends Ship {

	public Boat() {
		// TODO Auto-generated constructor stub
	}

	public Boat(String shipName, int fuelTank) {
		super(shipName, fuelTank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sail(int dist) {
		// TODO Auto-generated method stub
		this.setFuelTank(this.getFuelTank() - (dist * 10));  
	}

	@Override
	public void refuel(int fuel) {
		// TODO Auto-generated method stub
		this.setFuelTank(this.getFuelTank() + (fuel * 10));
	}

}
