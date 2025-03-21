package work.com.workshop11.sample;

public class Vehicle {

	private int		maxWeight;
	private double	oilTankSize;
	private double 	efficiency;
	
	Vehicle(){}

	public Vehicle(int maxWeight, double oilTankSize, double efficiency) {
		super();
		this.maxWeight = maxWeight;
		this.oilTankSize = oilTankSize;
		this.efficiency = efficiency;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public double getOilTankSize() {
		return oilTankSize;
	}

	public void setOilTankSize(double oilTankSize) {
		this.oilTankSize = oilTankSize;
	}

	public double getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}

	@Override
	public String toString() {
		return String.format("%-6s\t\t%-6s", maxWeight, oilTankSize);
	}
	
	
	
	
}
