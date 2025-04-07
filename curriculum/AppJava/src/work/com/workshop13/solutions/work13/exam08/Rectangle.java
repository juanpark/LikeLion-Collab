package work.com.workshop13.solutions.work13.exam08;

public class Rectangle extends Shape implements Movable {
    private int width;

    public Rectangle() {}

    public Rectangle(int width, int x, int y) {
        super(new Point(x, y));
        this.width = width;
    }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    @Override
    public double getArea() {
        return width * width;
    }

    @Override
    public double getCircumference() {
        return 4 * width;
    }

    @Override
    public void move(int x, int y) {
        point.setX(x + 2);
        point.setY(y + 2);
    }
}