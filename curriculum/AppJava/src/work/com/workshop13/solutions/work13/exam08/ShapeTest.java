package work.com.workshop13.solutions.work13.exam08;

import java.util.ArrayList;

public class ShapeTest {
	public static void main(String[] args) {
		ArrayList<Shape> shapes = new ArrayList<>();

		// // ArrayList를 만들어 [1.사용데이터]의 객체의 순서대로 Circle 객체와 Rectangle
		// 객체를 생성하여 넣는다

		shapes.add(new Rectangle(4, 7, 5));
		shapes.add(new Rectangle(5, 4, 6));
		shapes.add(new Circle(6, 6, 7));
		shapes.add(new Circle(7, 8, 3));

		// 모든 객체의 넓이 정보와 둘레 정보를 화면에 출력 한다. – for 문 이용
		System.out.printf("%-10s %-5s %-6s %-6s %-10s %-13s%n",
			    "구분", "길이", "X좌표", "Y좌표", "Area", "Circumference");

			for (Shape shape : shapes) {
			    if (shape instanceof Rectangle rect) {
			        System.out.printf("%-10s %-5d %-6d %-6d %-10.0f %-13.0f%n",
			            "Rectangle", rect.getWidth(), rect.getPoint().getX(), rect.getPoint().getY(),
			            rect.getArea(), rect.getCircumference());
			    } else if (shape instanceof Circle circ) {
			        System.out.printf("%-10s %-5d %-6d %-6d %-10.0f %-13.0f%n",
			            "Circle", circ.getRadius(), circ.getPoint().getX(), circ.getPoint().getY(),
			            circ.getArea(), circ.getCircumference());
			    }
			}

		// 모든 객체들에 move()함수를 이용하여 x가 10증가, y가 10증가
		// 되도록 변경 한 후 객체 정보를 화면에 출력 한다. – for 문 이용
			System.out.println("\n이동 후...");

			for (Shape shape : shapes) {
			    if (shape instanceof Movable m) {
			        m.move(shape.getPoint().getX() + 10, shape.getPoint().getY() + 10);
			    }
			}
			
			for (Shape shape : shapes) {
			    switch (shape) {
			        case Rectangle rect -> System.out.printf("%-10s %-5d %-6d %-6d%n",
			            rect.getClass().getSimpleName(), rect.getWidth(), rect.getPoint().getX(), rect.getPoint().getY());
			        case Circle circ -> System.out.printf("%-10s %-5d %-6d %-6d%n",
			            circ.getClass().getSimpleName(), circ.getRadius(), circ.getPoint().getX(), circ.getPoint().getY());
			        default -> System.out.println("Unknown shape");
			    }
			}


	}
}
