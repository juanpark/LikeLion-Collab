package work.com.workshop13.com.ship;

public class Cruise extends Ship {

	public Cruise() {
		// TODO Auto-generated constructor stub
	}

	public Cruise(String shipName, int fuelTank) {
		super(shipName, fuelTank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sail(int dist) {
		// TODO Auto-generated method stub
		this.setFuelTank(this.getFuelTank() - (dist * 13));
	}

	@Override
	public void refuel(int fuel) {
		// TODO Auto-generated method stub
		this.setFuelTank(this.getFuelTank() + (fuel * 8));
	}
	
}
