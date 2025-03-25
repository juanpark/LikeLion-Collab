package work.com.workshop11.sample;

public class Car extends Vehicle {
	private double restOil;
	private int curWeight;

	public Car() {
	}

	public Car(int maxWeight, double oilTankSize, double efficiency) {
		super(maxWeight, oilTankSize, efficiency);
		this.restOil = 0;
		this.curWeight = 0;
	}

	public void addOil(int oil) {
		double tankSize = getOilTankSize();
		if (restOil + oil <= tankSize)
			restOil += oil;
		else
			restOil = tankSize;
	}

	public void moving(int distance) {
		double usedOil = distance / getEfficiency();
		restOil = Math.max(0, restOil - usedOil);
	}

	public void addWeight(int weight) {
		if (curWeight + weight <= getMaxWeight()) {
			curWeight += weight;
		}
	}

	public double getRestOil() {
		return restOil;
	}

	public int getCurWeight() {
		return curWeight;
	}

	public void setRestOil(double restOil) {
		this.restOil = restOil;
	}

	public void setCurWeight(int curWeight) {
		this.curWeight = curWeight;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + restOil + "\t" + curWeight;
	}
}
