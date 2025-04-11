package com.sec16;

public class d_exam {
	public static void main(String[] args) {
		System.out.println("Thread started. State: " + Thread.currentThread().getState());
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().isDaemon());
	}
}
