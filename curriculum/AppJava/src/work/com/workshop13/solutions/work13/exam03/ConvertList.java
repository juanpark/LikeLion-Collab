package work.com.workshop13.solutions.work13.exam03;

import java.util.ArrayList;

public class ConvertList {
    public ArrayList<Integer> convertList(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        // 뒤에서부터 ArrayList에 삽입
        for (int i = array.length - 1; i >= 0; i--) {
            list.add(array[i]);
        }

        return list;
    }
}
