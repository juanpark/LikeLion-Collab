package work.com.workshop1;

public class Test05 {
	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = (((float)fahrenheit - 32) * 5) / 9 ;
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);
				
		/*
		 	Fahrenheit:100
			Celcius:37.77778
			
		
		 	* 공식: 섭씨 = ((화씨 - 32) x 5) / 9
		 	* fahrenheit는 int이기 때문에 계산도 int로 이루어져 소숫점 뒤는 절삭된다. 이를
		 	방지하기 위해서는 float로 cast한 후 진행한다!
		 	
		 */
	}

}
