package com.exam;
// 의존성 주입 -> 결합도 약하게 -> 패턴을 느슨하게 만들었다
// 1. 인터페이스를 지정해서 추상화 
// 2. 생성자를 통해 필요한 의존성 (InputDevice, Display)을 주입 -> 객체를 직접 생성하지 않는다.
// 3. 각 메서드 구현시 편하게 호출이 가능하다.


interface InputDevice {
    void input();
}

class WiredKeyboard implements InputDevice {
    @Override
    public void input() {
        System.out.println("유선 키보드를 입력합니다.");
    }
}

 class WirelessKeyboard implements InputDevice {
    @Override
    public void input() {
        System.out.println("무선 키보드를 입력합니다.");
    }
}

 interface Display {
    void show();
}

 class LcdMonitor implements Display {
    @Override
    public void show() {
        System.out.println("LCD 화면에 표시합니다.");
    }
}

class LedMonitor implements Display {
    @Override
    public void show() {
        System.out.println("LED 화면에 표시합니다.");
    }
}

public class ComputerDI {
    private InputDevice inputDevice;
    private Display display;

    // 생성자를 통해 필요한 의존성(InputDevice, Display)을 주입 -> 의존성이 낮다
    public ComputerDI(InputDevice inputDevice, Display display) {
        this.inputDevice = inputDevice;
        this.display = display;
    }

    public void start() {
        inputDevice.input();
        display.show();
        System.out.println("컴퓨터가 시작되었습니다.");
    }

    public static void main(String[] args) {
        // 사용할 InputDevice와 Display 구현체를 선택하여 Computer 객체를 생성
    	
        InputDevice wiredKeyboard = new WiredKeyboard();
        Display lcdMonitor = new LcdMonitor();
        ComputerDI computer1 = new ComputerDI(wiredKeyboard, lcdMonitor);
        computer1.start();

        InputDevice wirelessKeyboard = new WirelessKeyboard();
        Display ledMonitor = new LedMonitor();
        ComputerDI computer2 = new ComputerDI(wirelessKeyboard, ledMonitor);
        computer2.start();
    }
}