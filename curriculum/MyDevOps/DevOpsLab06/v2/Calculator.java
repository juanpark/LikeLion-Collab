public class Calculator {
    public static void main(String[] args) throws InterruptedException {
        int a = 10, b = 5;
        while (true) {
            System.out.println("버전 2.0 실행 중...");
            System.out.println("덧셈 : " + (a + b));
            System.out.println("뺄셈 : " + (a - b));
            System.out.println("곱셈 : " + (a * b));
            System.out.println("나눗셈 : " + (a / b));
            Thread.sleep(5000); // Wait 5 seconds before repeating
        }
    }
}
