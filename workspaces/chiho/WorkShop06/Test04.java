package Work.WorkShop06;

import java.util.Random;

public class Test04 {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("다시 입력 하세요");
            return;
        }

        int row = 0, col = 0;
        row = Integer.parseInt(args[0]);
        col = Integer.parseInt(args[1]);

        if (row < 1 || row > 5 || col < 1 || col > 5) {
            System.out.println("숫자를 확인 하세요");
            return;
        }
        int[][] arr = new int[row][col];
        Random rand = new Random();
        double sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int randomNumber = rand.nextInt(5) + 1; // 1~5
                arr[i][j] = randomNumber;
                sum += randomNumber;

            }
        }


        System.out.println("배열 내용:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        double average = (double) sum / (row * col);
        System.out.printf("총합: %.2f\n", sum);
        System.out.println("평균: " + average);
    }

    }
