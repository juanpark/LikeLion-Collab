package work.com.workshop13.com.shape;

import java.util.ArrayList;

public class ShapeTest {

	public static void main(String[] args) {
		// ArrayList를 만들어 [1.사용데이터 ]의 객체의 순서대로 Circle 객체 와 Rectangle 객체 를 생성 하여 넣는다
		ArrayList<Shape> shapeList = new ArrayList<>();
		Shape shape; // 부모 클래스로 선언
		
		shapeList.add(new Rectangle(4, 7, 5)); // 개별 자식 클래스로 객체 생성
		shapeList.add(new Rectangle(5, 4, 6));
		shapeList.add(new Circle(6, 6, 7));
		shapeList.add(new Circle(7, 8, 3));
		
		// 모든 객체의 넓이 정보와 둘레 정보를 화면에 출력 한다.
		// header 출력
		System.out.printf("%-10s %-2s %-3s %-3s  %-4s %-10s\n", 
				"구분", "길이", "X좌표", "Y좌표", "Area", "Circumference");
		
		// 난이도를 올린 부분 > 부모 클래스로 루프 중이라 자식 클래스에만 있는 메소드 호출하기 위해서는 캐스팅 필요
		// 삼항 연산자로 instanceof 값에 따라 맞는 자식 클래스로 캐스팅 하여 각각 getWidth() 또느 getRadius() 호출
		for (Shape s : shapeList) {
			System.out.printf("%-10s  %-2d  %-3d  %-3d   %-4.0f     %-10.0f\n",
					s.getClass().getSimpleName(), 
					(s instanceof Rectangle ? ((Rectangle) s).getWidth() : ((Circle)s).getRadius()),
					s.getPoint().getX(), s.getPoint().getY(),
					s.getArea(), s.getCircumference()
			);
		} // end for
		// 모든 객체들에 move()함수를 이용하여 x가 10증가 , y가 10증가 되도록 변경 한 후 객체 정보를 화면에 출력 한다.
		// move(x,y) 메소드 또한 부모 클래스에 없고 자식 클래스가 인터페이스를 구현 한 부분이라 인터페이스까지 캐스팅으로 실행
		for (Shape s : shapeList ) {
			if (s instanceof Movable) {
				((Movable)s).move(10, 10);
			}
		} // end for
		
		System.out.println("이동 후...");
		for (Shape s : shapeList) {
			System.out.printf("%-10s  %-2d  %-3d  %-3d\n",
					s.getClass().getSimpleName(), 
					(s instanceof Rectangle ? ((Rectangle) s).getWidth() : ((Circle)s).getRadius()),
					s.getPoint().getX(), s.getPoint().getY()
			);
		} // end for
		

	}// end main

}// end class

/*
넓이와 둘레는 소수점 첫 자리에서 반올림 한다.
구분 			길이 X좌표 	Y좌표 	Area Circumference
Rectangle 	4 	7 		5 		16 		16
Rectangle 	5 	4 		6 		25 		20
Circle 		6 	6 		7 		113 	38
Circle 		7 	8 		3 		154 	44

이동 후...
Rectangle 	4 	19 		17
Rectangle 	5 	16 		18
Circle 		6 	17 		18
Circle 		7	19 		14
*/