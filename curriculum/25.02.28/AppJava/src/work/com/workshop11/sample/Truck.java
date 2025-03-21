package work.com.workshop11.sample;



public class Truck extends Car {

    public Truck() {}

    public Truck(int maxWeight, double oilTankSize, double efficiency) {
        super(maxWeight, oilTankSize, efficiency);
    }

    // 현재 연비 계산 (적재량에 따라 감소)
    public double getEfficiency() {
        double reduction = (getCurWeight() / 5) * 0.2;
        double eff = super.getEfficiency() - reduction;
        return Math.max(0.1, eff);  // 최소 연비 보장
    }

    // 주행 처리
    public void moving(int distance) {
        double usedOil = calcOil(distance);
        double newRestOil = getRestOil() - usedOil;
        setRestOil(Math.max(0, newRestOil));
    }

    // 소모 오일량 계산
    private double calcOil(int distance) {
        return distance / getEfficiency();
    }

    // 요금 계산 (1L당 3000원, 소수점 버림)
    public int getCost(int distance) {
        double usedOil = calcOil(distance);
        return (int) (usedOil * 3000);
    }

    @Override
    public String toString() {
        return getMaxWeight() + "\t" + getOilTankSize() + "\t" + getRestOil() + "\t" + getCurWeight() + "\t" + String.format("%.1f", getEfficiency());
    }
}
