package com.exam;

// 의존성 주입 x
// 강한 결합도 : has~a 관계에서 행동 패턴을 기준으로 객체 생성 직접 구현한 상태
// 
class Keyboard {
    public void type() {
        System.out.println("키보드를 입력합니다.");
    }
}

class Monitor {
    public void display() {
        System.out.println("화면에 표시합니다.");
    }
}

public class ComputerMain {
    private Keyboard keyboard;
    private Monitor monitor;

    public ComputerMain() {
        // ComputerMain 클래스 내부에서 직접 Keyboard와 Monitor 객체를 생성
    	// 결합도가 높다 = 강한 결합 
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
    }

    public void start() {
        keyboard.type();
        monitor.display();
        System.out.println("컴퓨터가 시작되었습니다.");
    }

    public static void main(String[] args) {
        ComputerMain computer = new ComputerMain();
        computer.start();
    }
}