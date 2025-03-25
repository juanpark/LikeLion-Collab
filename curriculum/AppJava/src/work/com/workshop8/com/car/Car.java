package work.com.workshop8.com.car;

public abstract class Car {
	private String 	name;
	private String 	engine;
	private int 	oilTank;	// Oil tank size
	private int		oilSize;	// Oil being filled
	private int		distance;	// distance driven
	
	
	public Car() {
		// TODO Auto-generated constructor stub
	}


	public Car(String name, String engine, int oilTank, int oilSize, int distance) {
		super();
		this.name = name;
		this.engine = engine;
		this.oilTank = oilTank;
		this.oilSize = oilSize;
		this.distance = distance;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEngine() {
		return engine;
	}


	public void setEngine(String engine) {
		this.engine = engine;
	}


	public int getOilTank() {
		return oilTank;
	}


	public void setOilTank(int oilTank) {
		this.oilTank = oilTank;
	}


	public int getOilSize() {
		return oilSize;
	}


	public void setOilSize(int oilSize) {
		this.oilSize = oilSize;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	// distance 만큼 주행 하고 현재 주유량을 감소 한다
	public void go(int distance) { 
		this.setOilSize(this.getOilSize() - distance);
		this.setDistance(this.getDistance() + distance);
	}
	
	public void setOil(int oilSize) {
		this.setOilSize(this.getOilSize() + oilSize);
	}
}
	
