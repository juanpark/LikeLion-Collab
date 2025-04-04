package work.com.workshop13.com.shape;

public class Circle extends Shape implements Movable {

	private int radius;
	
	public Circle() {
		// TODO Auto-generated constructor stub
	}

	public Circle(int radius, int x, int y) {
		super(new Point(x, y));
		this.radius = radius;
	}

	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(this.getRadius(), 2);
	}

	@Override
	public double getCircumference() {
		return 2 * Math.PI * this.getRadius();
	}

	@Override
	public void move(int x, int y) {
		this.point.setX(this.point.getX() + (x + 1));
		this.point.setY(this.point.getY() + (y + 1));

	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	

}
