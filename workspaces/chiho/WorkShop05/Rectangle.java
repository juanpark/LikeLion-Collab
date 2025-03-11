package Work.WorkShop05;

public class Rectangle extends Shape implements Resize{

    public Rectangle() {}
    public Rectangle(int width, int height, String color) {
        super(width, height, color);
    }

    @Override
    public double getArea() {
        // 왜 다시 선언하라고 하는겨?
        return super.getArea();
    }

    @Override
    public void setResize(int size) {
//        Rectangle에서의 setResize() 함수는 가로(width)의 값에 size 값을 더한다
        this.width += size;
    }
}
