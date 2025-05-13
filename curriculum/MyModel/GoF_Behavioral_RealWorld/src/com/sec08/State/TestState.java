package com.sec08.State;

// TCP/IP 통신로직
// 전등스위치를 켜고 끄기
interface State {
    void handle();
}

class OnState implements State {
    public void handle() { System.out.println("Turned ON"); }
}

class OffState implements State {
    public void handle() { System.out.println("Turned OFF"); }
}

public class TestState {
    public static void main(String[] args) {
        State state = new OnState();
        state.handle();
        state = new OffState();
        state.handle();
    }
}
