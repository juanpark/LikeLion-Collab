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
        
        /*
         * 	Thread.start()	-> JVM은 OS에 커널 스레드 요청
         * 	-> OS 해당 스레드를 스케줄링을 한다 (시간 할당, 우선 순위 고려) 
         * 	-> JVM은 각 Thread 객체에 Thread Stack을 할당 
         * 	-> 각 스레드는 독립적으로 Call Stack을 갖는다.
         */
        
        /*
      	 *	JConsole	: 프로세스와 스레드 메모리 상태 확인
      	 *	Overview	: CPU 사용량, HEAP 메모리, 클래스 수, 스레드 수
      	 *	Memory		: GC (전체 HEAP의 15% 이상 차지하게 되면 메모리 조정해야 함)
      	 *	Threads		: 스레드 목록, 상태 확인
      	 *	Classes		: 클래스 로딩 수, 메모리 점유량 확인
      	 *	VM Summary	: JVM 기본 설정값 (HEAP 크기, GC설정, 명령줄 옵션) 
      	 *	Mbeans		: User가 등록한 프로세스를 관리하는 목적 
         */		
         
    }
}