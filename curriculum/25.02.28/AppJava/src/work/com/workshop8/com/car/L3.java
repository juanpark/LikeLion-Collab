package work.com.workshop8.com.car;

public class L3 extends Car implements Temp {

	public L3() {
		// TODO Auto-generated constructor stub
	}

	public L3(String name, String engine, int oilTank, int oilSize, int distance) {
		super(name, engine, oilTank, oilSize, distance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getTempGage() {
		// 엔진 온도를 리턴 한다 10주행 시 엔진 온도 1증가
		return ((this.getDistance() / 10) * 1);
	}

	@Override
	public void go(int distance) {
		// 10주행 시 현재 주유량 1 감소
		this.setOilSize(this.getOilSize() - ((distance / 10) * 1));
		this.setDistance(this.getDistance() + distance);
	}

	@Override
	public void setOil(int oilSize) {
		// TODO Auto-generated method stub
		super.setOil(oilSize);
	}

	
}
