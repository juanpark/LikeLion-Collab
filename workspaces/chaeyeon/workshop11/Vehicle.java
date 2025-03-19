package work.com.workshop11;

public class Vehicle {
	private int maxWeight;
	private double oilTankSize;
	private double efficiency;

	public Vehicle() {}

	public Vehicle(int maxWeight, double oilTrackSize, double efficiency) {
		this.maxWeight = maxWeight;
		this.oilTankSize = oilTrackSize;
		this.efficiency = efficiency;
	}


	@Override
	public String toString() {
		return String.format("%5d %.1f",maxWeight,oilTankSize);
		//문자열 리턴
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


















}
