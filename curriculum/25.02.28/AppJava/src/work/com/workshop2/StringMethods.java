package work.com.workshop2;

public class StringMethods {

    public static void main(String[] args) {
        // Q1
        q1();
        // Q2
        q2();
        // Q3
        q3();
        // Q4
        q4();
        // Q5
        q5();
        // Q6
        q6();
        // Q7
        q7();
        // Q9
        q9();
        // Q10
        q10();
        // Q11
        q11();
        // Q12
        q12();
        // Q13
        q13();
        // Q14
        q14();
        // Q15
        q15();
        //Q16
        q16();
    }

   

	public static void q1() {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + s2;
        System.out.println("Q1: " + (s3 == "HelloWorld")); // false
    }

    public static void q2() {
        String multiLine = """
                Hello
                World
                """;
        System.out.println("Q2: " + multiLine.stripIndent()); // Hello\nWorld
    }

    private static void q3() {		
    	     String str  =" \t abc ";
    	     System.out.println( "Q3: "+ str.translateEscapes() );
		
	}
    public static void q4() {
        String input = "Java 21 is awesome!";
        System.out.println("Q4: " + input.replaceAll("\\d+", "XX")); // Java XX is awesome!
    }

    public static void q5() {
        String str = "Java";
        System.out.println("Q5: " + str.indent(4)); //     Java
    }

    public static void q6() {
        String str = "   Hello World   ";
        System.out.println("Q6: " + str.strip()); // Hello World
    }

    public static void q7() {
        String str = "Java";
        System.out.println("Q7: " + str.repeat(3)); // JavaJavaJava
    }

    public static void q9() {
        String text = "Java\n21\nRocks";
        System.out.print("Q9: ");
        text.lines().forEach(System.out::println); // Java\n21\nRocks
    }

    public static void q10() {
        String str = "abcdef";
        System.out.println("Q10: " + str.substring(2, 5)); // cde
    }

    public static void q11() {
        String str = "  Java 21  ";
        System.out.println("Q11: " + str.trim()); // Java 21
    }

    public static void q12() {
        String str = "Hello";
        System.out.println("Q12: " + str.charAt(1)); // e
    }

    public static void q13() {
        String str = "Hello,World";
        String[] arr = str.split(",");
        System.out.println("Q13: " + arr[1]); // World
    }

    public static void q14() {
        String str = "Hello";
        System.out.println("Q14: " + str.replace("l", "X")); // HeXXo
    }

    public static void q15() {
        String str = "Hello";
        System.out.println("Q15: " + str.contains("el")); // true
    }

    public static void q16() {
        System.out.println("Q16: String.join() 메서드는 주어진 문자열들을 특정 구분자로 연결합니다.");
        String message = String.join("-", "Java", "is", "cool");
        System.out.println(message);
    }
}