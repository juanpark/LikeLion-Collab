package com.sec05.Facade;

// is~a 관계의 복잡한 패턴을 단일 has~a 관계로 호출해서 사용할 수 있도록 유연하게 만드는 패턴   
// 싱클톤으로 구현(= 구체클래스)해서 has~a 
public class CarFacade {
    private final Engine engine = new Engine();
    private final Lights lights = new Lights();

    public void startCar() {
        lights.turnOn();
        engine.start();
    }
}
