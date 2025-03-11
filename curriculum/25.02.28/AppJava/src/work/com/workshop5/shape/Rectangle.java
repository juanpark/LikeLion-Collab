package work.com.workshop5.shape;

public class Rectangle extends Shape implements Resize {

	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int width, int height, String colors) {
		super(width, height, colors);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getArea() {
		return this.width * this.height;
	}

	@Override
	public void setResize(int size) {
		// Rectangle에서의 setResize() 함수는 가로(width)의 값에 size 값을 더한다
		this.width = this.width + size;	
	}
	
	
	
}
