package work.com.workshop13.com.shape;

public abstract class Shape {
	// # point:Point -> 클래스 다이어그램 해석 설명 해 주신 적 있나?
	protected Point point;
	
	public Shape() {
		
	}
	public Shape(Point point) {
		this.point = point;
	}
	
	public abstract double getArea();
	
	public abstract double getCircumference();

	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}

	
}
