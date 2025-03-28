package work.com.workshop12.solutions;
import java.util.Arrays;
public class Exam05 {
	
	    public static void main(String[] args) {
	        String str = "I am second to none";

	        // 1. 문자 하나씩 공백으로 출력 (공백 제외)
	        str.chars()
	                .filter(c -> c != ' ')           // 공백 제거
	                .mapToObj(c -> (char) c + " ")   // 문자 뒤에 공백 추가
	                .forEach(System.out::print);
	        System.out.println();

	        // 2. 문자 개수 출력 (공백 제외)
	        long charCount = str.chars()
	                .filter(c -> c != ' ')
	                .count();
	        System.out.println("문자 개수: " + charCount);

	        // 3. 원래 문자열 출력
	        System.out.println(str);

	        // 4. 단어 개수 출력 (공백 기준 split 후 Stream으로 처리)
	        long wordCount = Arrays.stream(str.split(" "))
	                .filter(s -> !s.isEmpty())   // 혹시 모를 빈 문자열 제거
	                .count();
	        System.out.println("단어 개수: " + wordCount);
	    }
	}


