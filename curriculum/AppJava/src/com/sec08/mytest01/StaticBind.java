package com.sec08.mytest01;

import java.util.*;

public class StaticBind {
	public static void main(String[] args) {
		System.out.println(" inpunt No  :[강아지 1 , 야옹이 2, 오리 3, Exit et]");
		Scanner sc = new Scanner(System.in);
		while (true) {
		System.out.print("\n Choice no :");
			int no = sc.nextInt();
			switch (no) {
			case 1:
				Puppy p = new Puppy();
				p.Start();
				p.Stop();
				break;
			case 2:
				Cat c = new Cat();
				c.Start();
				c.Stop();
				break;
			case 3:
				Duck d = new Duck();
				d.Start();
				d.Stop();
				break;
			default:
				System.exit(0);
			}
		}
	}
}
