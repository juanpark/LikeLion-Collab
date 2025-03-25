package work.com.workshop7.com.elite.test01;

public class ArrayTest {

	public static void main(String[] args) {
		
		int [][] array = {
			{12, 41, 36, 56, 21},
			{82, 10, 12, 61, 45},
			{14, 16, 18, 78, 65},
			{45, 26, 72, 23, 34}
		};
		
		int row = array.length;
		int column = array[0].length;
		int arrayLength = row * column;
		int total = 0;
		
		// 2차원 배열 순회하기
		for (int[] rows : array) {
			for (int element : rows) {
				total += element;
			} // end inner loop
		}// end outer loop
		
		// 연산 결과가 실수로 저장 되도록 연산부터 실수로 캐스팅
		double avg = (double)total / arrayLength;
		
		// 정수로 받은 합계 값은 실수를 원하는 경우라 실수로 캐스팅
		System.out.println("합계 : " + (double)total);
		System.out.println("평균 : " + avg);
		
	}// end main
}// end class
