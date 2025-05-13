package com.sec07.Observer;

import java.util.*;

/*
	관찰자는 주체에 등록 
	-> 주체 상태가 변경되면, 주체는 모든 관찰자에게 알람을 전송
	-> 각 관찰자는 알람을 받으면 정의도니 방식대로 명령을 수행
	-> 관찰자는 필요에 따라 주체의 등록을 해제할 수 있어야 함
*/

// 상태 변화는 1:N 형태로 진행된다. -> 하나의 주체는 여러개의 관찰자를 가질 수 있다.

// 관찰 객체
interface Observer { void update(); } // 주체의 상태 변화 시 호출 

// 주체
class Subject {
    private List<Observer> observers = new ArrayList<>();
    public void add(Observer o) { observers.add(o); }
    public void notifyAllObservers() { for (Observer o : observers) o.update(); }
}

class ConcreteObserver implements Observer {
    public void update() { System.out.println("Notified!"); }
}

public class TestObserver {
    public static void main(String[] args) {
        Subject s = new Subject();
        s.add(new ConcreteObserver());
        s.notifyAllObservers();
    }
}
