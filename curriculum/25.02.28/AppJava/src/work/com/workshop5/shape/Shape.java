package work.com.workshop5.shape;

abstract class Shape {

	int width;
	int height;
	String colors;
	
	// constructor
	public Shape() {
		
	}
	
	// constructor with parameters
	public Shape(int width, int height, String colors) {
		super();
		this.width = width;
		this.height = height;
		this.colors = colors;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}
	
	// abstract method
	public abstract double getArea();
	
	
}
