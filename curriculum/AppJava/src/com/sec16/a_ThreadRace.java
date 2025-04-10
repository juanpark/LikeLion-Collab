package com.sec16;
//  case01 확장: Thread 상속 기반 경주 게임
//https://emojipedia.org/ 
//https://getemoji.com/
//  이모지 팝업창 윈도우 Windows + . (마침표) 또는 Windows + ; (세미콜론)
//             맥 Control + Command + Space


class RacerThread extends Thread {
    private static int finishOrder = 1; // 도착 순위 (공유 변수)

    public RacerThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + "🏃‍♂️: " + i + "미터");
            try {
                Thread.sleep((int)(Math.random() * 400 + 100)); // 100~500ms 랜덤 지연
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (RacerThread.class) {
            System.out.println("🎉 " + getName() + " 도착! 순위: " + finishOrder++);
        }
    }
}

public class a_ThreadRace {
    public static void main(String[] args) {
        RacerThread thread1 = new RacerThread("🐢 느린이");
        RacerThread thread2 = new RacerThread("🐇 빠른이");

        thread1.start();
        thread2.start();
    }
}