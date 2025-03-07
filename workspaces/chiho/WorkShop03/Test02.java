package Work.WorkShop03;
//다음의 for문을 while문으로 변경 하시오
//public class Test02 {
//    public static void main(String[] args) {
//        for(int i=0; i<=10; i++) {
//            for(int j=0; j<=i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }
//}




public class Test02 {
    public static void main(String[] args) {


        int i= 0;

        while(i<=10)
        {
            int j = 0;
            while(j<=i)
            {
                System.out.print("*");
                j++;
            }

            System.out.println();
            i++;
        }

//        for(int i=0; i<=10; i++) {
//            for(int j=0; j<=i; j++)
//            {
//                System.out.print("*");
//            }
//            System.out.println();
//        }


    }

}

