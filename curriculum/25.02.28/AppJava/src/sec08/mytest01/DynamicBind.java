package com.sec08.mytest01;
import java.util.*;

public class DynamicBind {
	public static void main(String[] args) {
		System.out.println(" inpunt No  :[강아지 1 , 야옹이 2, 오리 3, Exit et]");
		Scanner sc = new Scanner(System.in);
		Base base = null;
		while (true) {
			System.out.print("\n Choice no :");
			int no = sc.nextInt();
			switch (no) {
			case 1:
				base = new Puppy();
				break;
			case 2:
				base = new Cat();
				break;
			case 3:
				base = new Duck();
				break;
			default:
				System.exit(0);
			}
			base.Start();
			base.Stop();
		}
	}
}
