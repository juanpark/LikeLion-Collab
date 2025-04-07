package work.com.workshop13.solutions.work13.exam02;

import java.util.ArrayList;
import java.util.Random;

public class MakeList {
    ArrayList<Integer> list;

    public MakeList() {
        list = new ArrayList<>();
    }
    
    // ArrayList 생성 
    public void makeArrayList(int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(10) + 10;  // 10 ~ 19
            list.add(num);
        }
    }
   //ArrayList의 모든 값의 평균을 계산 하여 리턴 
    public double getAverage() {
        if (list == null || list.isEmpty()) return 0.0;

        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return (double) sum / list.size();
    }
    //ArrayList를 리턴 
    public ArrayList<Integer> getList() {
        return list;
    }
}
