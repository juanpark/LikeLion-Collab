package work.com.workshop5.shape;

public class ShapeTest {

	public static void main(String[] args) {
		
		// Shape 객체 배열에 모양별로 생성한 객체를 입력 
		Shape[] shapes = new Shape[6];
		shapes[0] = new Triangle(7, 5, "Blue");
		shapes[1] = new Rectangle(4, 6, "Blue");
		shapes[2] = new Triangle(6, 7, "Red");
		shapes[3] = new Rectangle(8, 3, "Red");
		shapes[4] = new Triangle(9, 8, "White");
		shapes[5] = new Rectangle(5, 7, "White");
		
		// 각 객체 배열 내 모양 정보 프린트
		System.out.println("기본정보");
		for (Shape shape : shapes) {
			System.out.printf("%-10s  %5.1f    %-5s\n", shape.getClass().getSimpleName(), shape.getArea(), shape.getColors());
		}
		
		System.out.println();
		System.out.println("사이즈를 변경 후 정보");
		// 각 객체 배열 내 모양 크기 변경
		for (Shape shape : shapes) {
			// Shape 추상클래스에는 없는 부분이기에 Resize 인터페이스로 동적 바인딩
//			((Resize) shape).setResize(5); 
			
			// 강사님 추천 형변환 후 호출 
			if (shape instanceof Resize r) {
				r.setResize(5);;
			}
			
			// Shape abstract implements Resize interface (no need for casting?)
			// shape.setResize(5);
			
			// 각 객체 배열 내 모양 정보 프린트
			System.out.printf("%-10s  %5.1f    %-5s\n", shape.getClass().getSimpleName(), shape.getArea(), shape.getColors());
		}
	}

}


