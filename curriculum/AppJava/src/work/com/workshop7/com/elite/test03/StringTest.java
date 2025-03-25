package work.com.workshop7.com.elite.test03;

import java.util.StringTokenizer;

public class StringTest {

	public static void main(String[] args) {
		// 주어진 String 데이터를 “,”로 나누어 5개의 실수 데이터를 추출하고 합과 평균을 구한다.
		// 단, String 문자열의 모든 실수 데이터를 배열로 만들어 계산한다.
		
		String 	str = "1.22,4.12,5.93,8.71,9.34";
		
		double 	data []= new double[5];
		double 	sum = 0;
		
		// StringTokenizer를 이용하여 데이터를 꺼낸다.
		StringTokenizer tokenizer = new StringTokenizer(str, ",");
		// 데이터가 몇개 있는지 저장
		int tokenNumber = tokenizer.countTokens();
		
		
		// tokenizer.hasMoreTokens()로 boolean 값제공
		for(int i = 0; tokenizer.hasMoreTokens(); i++){
			// 배열에 실수 데이터를 넣는다.
			// String을 Double객체로 캐스팅
			data[i] = Double.parseDouble(tokenizer.nextToken());
			//배열 데이터의 합을 구한다.
			sum += data[i];
		}
		// 결과 값을 출력한다.
		System.out.printf("합계 : %.3f\n", sum);
		System.out.printf("평균 : %.3f\n", sum / tokenNumber);  

	}

}
