package work.com.workshop11;

class Car extends Vehicle {
    private double restOil;
    private int curWeight;

    public Car() {}

    public Car(int maxWeight, double oilTankSize, double efficiency) {
        super(maxWeight, oilTankSize, efficiency);
        this.restOil = 0;
        this.curWeight = 0;
    }

    public void addOil(int oil) {
        restOil = Math.min(getOilTankSize(), restOil + oil);
        //오일량 제한
    }

    public void moving(int distance) {
        restOil -= (distance / getEfficiency());
        //거리/연비=필요 오일량
    }

    public void addWeight(int weight) {
        if (curWeight + weight <= getMaxWeight()) {
            curWeight += weight;
        }
    }

    @Override
	public String toString() {
        return String.format("%s %.1f %d", super.toString(),restOil,curWeight);
    }

    @Override
	public double getEfficiency() {
        return super.getEfficiency();
    }

    public int getCurWeight() {
        return curWeight;
    }

    public void setRestOil(double restOil) {
        this.restOil = restOil;
    }

    public double getRestOil() {
        return restOil;
    }

}
