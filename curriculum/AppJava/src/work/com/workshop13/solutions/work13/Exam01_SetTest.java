package work.com.workshop13.solutions.work13;
import java.util.HashSet;
import java.util.Set;

public class Exam01_SetTest {
	public static void main(String[] args) {
		
		String input = args[0]; 
		
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        System.out.println(set);
	}
}
