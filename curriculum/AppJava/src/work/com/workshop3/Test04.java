package work.com.workshop3;
import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
		
		// Math.random() 0과 1 사이 double 소숫점 자리 리턴 (0,1 불포함)
		// [0, 1]의 범위를 [0, 6]의 범위로 바꾸려면 먼저 6을 곱해야 한다
		// 0.1 * 6 = 0.6, 0.9 * 6 = 5.4
		// 여기에서 int로 바꾸면 소숫점 뒷자리를 잘리기 때문에 0~5 범위이기 때문에 + 1을 해준 값을 int로 캐스팅한다
		
		int number = (int) (Math.random() * 6 + 1);
		
		System.out.println(number);

	}

}
