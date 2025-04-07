package work.com.workshop13.solutions.work13.exam02;

import java.util.ArrayList;

public class ListTest01 {
    public static void main(String[] args) {
        // argument로 정수를 받는다. 13 18 12 10 19 13 16 18 19 12  
        if (args.length == 0) {
            System.out.println("정수형 argument(size)를 입력하세요.");
            return;
        }

        int size = Integer.parseInt(args[0]);

        if (size < 5 || size > 10) {
            System.out.println("크기는 5 이상 10 이하로 입력해야 합니다.");
            return;
        }

        // MakeList 객체 생성
        MakeList maker = new MakeList();

        // 무작위의 번호 발생 후 저장
        maker.makeArrayList(size);

        // ArrayList 객체 참조
        ArrayList<Integer> list = maker.getList();

        // for문을 이용하여 ArrayList의 정보 출력하고 평균을 출력한다.
        System.out.println("생성된 랜덤 숫자 리스트:");
        for (int num : list) {
            System.out.print(num + " ");
        }

        // 평균 출력
        System.out.printf("\n평균: %.2f\n", maker.getAverage());
    }
}