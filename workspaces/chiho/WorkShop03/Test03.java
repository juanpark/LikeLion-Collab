package Work.WorkShop03;

public class Test03 {
    public static void main(String[] args) {
        for(int i = 1;i<6;i++)
        {
            for(int j = 1;j<6;j++)
            {
                if(i+j == 6) {
                    System.out.printf("%2d + %2d = %2d", i, j, i + j);
                    System.out.println();
                }
            }
        }
    }


}
