package work.com.workshop3;

public class Test02 {

	public static void main(String[] args) {
		
		int i = 0;

		
		while (i <= 10) {
			int j = 0;		// j는 여기에 위치해 있어야 i가 루프를 끝낼 때마다 리셋되어 정상 작동
			while (j <= i) {
				System.out.print("*"); //println이 아닌 print로 추가하여 줄바꿈이 여기에서는 없도록.
				j++;
			}
			System.out.println();
			i++;
		}

	}

}
