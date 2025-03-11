package Work.WorkShop05;

public class Triangle extends Shape implements Resize{


    public Triangle()
    {

    }

    public Triangle(int width, int height, String color)
    {
        super(width, height, color);
    }

    @Override
    public double getArea() {
        return (double)(this.width*this.height/2.0);
    }

    @Override
    public void setResize(int size) {
        //Triangle에서의 setResize() 함수는 세로(height)의 값에 size 값을 더한다
        this.width += size;
    }


}
