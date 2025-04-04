package work.com.workshop13.com.shape;

public class Rectangle extends Shape implements Movable {

	private int width;
	
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int width, int x, int y) {
		super(new Point(x, y));
		this.width = width;
	}

	@Override
	public double getArea() {
		// length가 없어서 정사각형 구하는 버전 
		// (rectangle이 아니라 square인듯?)
		return Math.pow(this.getWidth(), 2);
	}

	@Override
	public double getCircumference() {
		// rectangle이니 perimeter
		return this.getWidth() * 4;
	}

	@Override
	public void move(int x, int y) {
		this.point.setX(this.point.getX() + (x + 2));
		this.point.setY(this.point.getY() + (y + 2));
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
}
