package work.com.workshop12.solutions;


import java.text.DecimalFormat;
import java.util.Scanner;

 class ConvertString {
    public String convert(int money) {
        // 3자리마다 콤마 찍기
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(money) + "원";
    }
 }
 public class Exam07{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("금액을 입력하세요: ");
        int money = scanner.nextInt();

        ConvertString converter = new ConvertString();
        String result = converter.convert(money);

        System.out.println("입력한 금액: " + money);
        System.out.println("변환된 금액: " + result);
    }
}
