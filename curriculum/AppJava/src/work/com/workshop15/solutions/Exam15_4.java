package work.com.workshop15.solutions;

class SleepThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("출력: " + i);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                System.out.println("스레드 인터럽트 발생");
            }
        }
    }
}
public class Exam15_4 {
    public static void main(String[] args) throws InterruptedException {
    	 SleepThread st = new SleepThread();
         st.start();
    }
}