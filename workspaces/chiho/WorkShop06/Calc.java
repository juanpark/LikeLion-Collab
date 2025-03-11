package Work.WorkShop06;

public class Calc {

    private int data;
    public static int calculate(int data)
    {
        int sum = 0;
        for(int i=1;i<=data;i++)
        {
            if(i%2==0)
            {
                sum+=i;
            }
        }
        return sum;
    }
}
