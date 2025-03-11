package Work.WorkShop05;

abstract class  Shape {

    int width;
    int height;
    String colors;

    Shape()
    {}

    Shape(int width, int height, String colors )
    {
        this.width = width;
        this.height = height;
        this.colors = colors;
    }

    public double getArea()
    {
        return (double)width * height;
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
}
