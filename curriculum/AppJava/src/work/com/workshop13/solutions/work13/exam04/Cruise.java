package work.com.workshop13.solutions.work13.exam04;

public class Cruise extends Ship {
    public Cruise() {}

    public Cruise(String shipName, int fuelTank) {
        super(shipName, fuelTank);
    }

    @Override
    public void sail(int dist) {
        setFuelTank(getFuelTank() - dist * 13);
    }

    @Override
    public void refuel(int fuel) {
        setFuelTank(getFuelTank() + fuel * 8);
    }
}
