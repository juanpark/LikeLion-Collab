package work.com.workshop11;

public class Truck extends Car {
    public Truck() {}

    public Truck(int maxWeight, double oilTankSize, double efficiency) {
        super(maxWeight, oilTankSize, efficiency);
    }

    @Override
    public double getEfficiency() {
        return Math.max(1.0, super.getEfficiency() - (getCurWeight() / 5.0 * 0.2));
    }

    @Override
    public void moving(int distance) {
        double oilConsumed = calcOil(distance);
        setRestOil(getRestOil() - oilConsumed);
    }

    private double calcOil(int distance) {
        return distance / getEfficiency();
    }

    public int getCost(int distance) {
        return (int) (calcOil(distance) * 3000);
    }

    @Override
    public String toString() {
        return String.format("%s %.1f", super.toString(), getEfficiency());
    }


}
