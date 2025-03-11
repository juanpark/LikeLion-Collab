package Work.WorkShop05;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape[] = new Shape[6];
            // (1.조건 )에서 주어진 데이터를 기반으로 Shape type의 객체를 생성 하여
            // 6개의 도형 객체를 배열에 넣는다.
            // 모든 객체의 넓이 정보와 색상 정보를 for Loop를 이용하여 화면에 출력 한다
            // 모든 객체들 을 setResize 함수를 이용하여 5 를 입력 하고 사이즈를 변경 후
            // 화면에 출력 한다. 단 for Loop문을 이용 한다.
        shape[0] = new Triangle(7, 5, "Blue");
        shape[1] = new Rectangle(4, 6, "Blue");
        shape[2] = new Triangle(6, 7, "Red");
        shape[3] = new Rectangle(8, 3, "Red");
        shape[4] = new Triangle(9, 8, "White");
        shape[5] = new Rectangle(5, 7, "White");

        System.out.println("기본 정보");
        System.out.println();

        for (Shape i : shape) {
            System.out.printf("%-10s %-10.1f %-10s \n" , i.getClass().getSimpleName(), i.getArea(), i.getColors());
        }

        for (Shape i : shape) {
            //setResize가 shape에는 없는 클래스이다! 다운캐스팅을 해야한다.
            /*

            * */
            ((Resize)i).setResize(5);
        }

        System.out.println();
        System.out.println();

        System.out.println("사이즈를 변경 후 정보");
        System.out.println();
        for (Shape i : shape) {
            System.out.printf("%-10s %-10.1f %-10s\n" , i.getClass().getSimpleName(), i.getArea(), i.getColors());
        }

    }
}
