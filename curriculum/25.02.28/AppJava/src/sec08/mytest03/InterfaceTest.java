package com.sec08.mytest03;

import java.util.List;

interface IShape {
	static final String COLOR = "red"; // final 명시적 선언

	void draw();
}

class Circle implements IShape {
	private final String type;

	public Circle(String type) {
		this.type = type;
	}

	@Override
	public void draw() {
		System.out.println(COLOR + "의 " + type + "을 그립니다.");
	}
}

class Rect implements IShape {
	private final String type;

	public Rect(String type) {
		this.type = type;
	}

	@Override
	public void draw() {
		System.out.println(COLOR + "의 " + type + "을 그립니다.");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		IShape[] is = new IShape[2];
		is[0] = new Circle("원");
		is[1] = new Rect("사각형");

		for (IShape r : is) {
			r.draw();
		}
	}
}
