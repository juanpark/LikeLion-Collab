package work.com.workshop13.solutions.work13.exam03;

import java.util.ArrayList;

public class ListTest02_Exam03 {

	    public static void main(String[] args) {
	        // 원본 배열 선언
	        int array[] = {3, 4, 2, 5, 2, 3, 6, 7, 5, 7, 9};

	        // ConvertList 객체 생성 및 리스트 변환
	        ConvertList converter = new ConvertList();
	        ArrayList<Integer> list = converter.convertList(array);

	        // 리스트 출력 (한 줄에 하나씩)
	        for (int num : list) {
	            System.out.println(num);
	        }
	    }
	}

