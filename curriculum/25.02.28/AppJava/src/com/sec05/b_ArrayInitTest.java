package com.sec05;

// 모든 자료형의 배열을 선언 -> 생성 -> 호출 확인!
public class b_ArrayInitTest {
	public static void main(String[] args) {
		int j = 0;
		char c[] = new char[2];
		byte b[] = new byte[2];
		boolean bool[] = new boolean[2];
		int i[] = new int[2];
		long l[] = new long[2];
		float f[] = new float[2];
		double d[] = new double[2];
		Object o[] = new Object[2];
		
		for (j = 0; j < b.length; j++) {
			System.out.print(" byte b[" + j + "]=" + b[j]);
		}
		System.out.println("\n==========================");

		for (j = 0; j < c.length; j++) {
			System.out.print(" char c[" + j + "]=" + c[j]);
		}
		System.out.println("\n==========================");

		for (j = 0; j < bool.length; j++) {
			System.out.print(" boolean bool[" + j + "]=" + bool[j]);
		}
		System.out.println("\n==========================");

		for (j = 0; j < i.length; j++) {
			System.out.print(" int i[" + j + "]=" + i[j]);
		}
		System.out.println("\n==========================");

		for (j = 0; j < l.length; j++) {
			System.out.print(" long l[" + j + "]=" + l[j]);
		}
		System.out.println("\n==========================");

		for (j = 0; j < f.length; j++) {
			System.out.print(" float  f[" + j + "]=" + f[j]);
		}
		System.out.println("\n==========================");

		for (j = 0; j < d.length; j++) {
			System.out.print(" double d[" + j + "]=" + d[j]);
		}
		System.out.println("\n==========================");

		for (j = 0; j < o.length; j++) {
			System.out.print(" object o[" + j + "]=" + o[j]);
		}
	}
	
}
