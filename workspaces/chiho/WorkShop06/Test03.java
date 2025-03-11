package Work.WorkShop06;

public class Test03 {

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int sum = 0;
        boolean first = true;
        for(int i = num;i<=10;i++) {
            if(i%3==0||i%5==0) {
                continue;
            }

            if (!first) {
                System.out.print(" + ");
            }
            System.out.printf(" %d ",i);
            sum+=i;
            first = false;
        }
        System.out.println();

        System.out.println("결과: "+sum);

    }
}
