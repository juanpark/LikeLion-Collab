package com.sec08.mytest02;

import java.util.Scanner;

abstract class ShapeX {
    private final int data1, data2;

    public ShapeX(int data1, int data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public int getData1() {
        return data1;
    }

    public int getData2() {
        return data2;
    }

    public abstract double getArea();
}

class Triangle extends ShapeX {
    public Triangle(int data1, int data2) {
        super(data1, data2);
    }

    @Override
    public double getArea() {
        return (double) (getData1() * getData2()) / 2;
    }

    @Override
    public String toString() {
        return "Triangle 넓이: " + getArea();
    }
}

class Rectangle extends ShapeX {
    public Rectangle(int data1, int data2) {
        super(data1, data2);
    }

    @Override
    public double getArea() {
        return (double) (getData1() * getData2());
    }

    @Override
    public String toString() {
        return "Rectangle 넓이: " + getArea();
    }
}

public class MShape {
    public static void main(String[] args) {
        System.out.println("\n*** Shape 선택 ***\n1. 삼각형\n2. 사각형\n3. 종료");

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("선택 (1-3) : ");
                int no = sc.nextInt();

                ShapeX sp = switch (no) {
                    case 1 -> new Triangle(2, 3);
                    case 2 -> new Rectangle(4, 5);
                    case 3 -> {
                        System.out.println("감사합니다.");
                        yield null;
                    }
                    default -> {
                        System.out.println("올바른 번호를 입력하세요.");
                        yield null;
                    }
                };

                if (sp == null) {
                    return; // 프로그램 종료
                }

                System.out.println(sp); // toString() 자동 호출
            }
        }
    }
}
