package Work.WorkShop06;

public class Test02 {

    public static void main(String[] args) {

//        if(Integer.parseInt(args[0]) == null){
//            return;
//        }
    int num = Integer.parseInt(args[0]);
        System.out.printf("입력 값: %d", num);
        System.out.println();
        System.out.printf("짝수: ");
        for (int i = 1; i < num; i++) {
            if(i%2 ==0)
            {
                System.out.printf("%d ", i);
            }


        }
        System.out.println();
        int result = Calc.calculate(num);
        System.out.printf("결과 값: %d", result);


    }// args값이 없으면 어떻게 될까?
}
