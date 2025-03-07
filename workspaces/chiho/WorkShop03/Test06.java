package Work.WorkShop03;

import java.util.Scanner;

public class Test06 {

    public static void main(String[] args) {


        System.out.printf("입력 예1: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

//        System.out.println(num);

        int sum = 0;
        for (int i = num; i <= 100; i+=num) {
            sum +=i;
            System.out.print(i);
            if(i+num<=100)
                System.out.print(" + ");
        }
        System.out.print(" = "+sum);
    }
}
