package work.com.workshop12.workshop.token;

import java.util.List;
import java.util.StringTokenizer;

public class StringTokenTest {

	public static void main(String[] args) {
		
		String str = "4,2,3,6,7";
		
		StringTokenizer token = new StringTokenizer(str, ",");
		
		int total = 0;
		
		while (token.hasMoreTokens()) {
			total += Integer.parseInt((token.nextToken()));
		}
		
		System.out.println(total);
	}

}
