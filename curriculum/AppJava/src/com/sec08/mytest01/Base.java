package com.sec08.mytest01;

public abstract class Base {
	
	public abstract void Start();

	public abstract void Stop();
}

class Cat extends Base {

	public void Start() {
		System.out.println("Cat 걸었네 ");

	}

	public void Stop() {

		System.out.println("Cat 멈추었네 ");
	}

}

class Duck extends Base {

	public void Start() {

		System.out.println("Duck 걸었네 ");
	}

	public void Stop() {

		System.out.println("Duck 멈추었네  ");
	}

}

class Puppy extends Base {
	public void Start() {
		System.out.println("Puppy 걸었네");
	}

	public void Stop() {
		System.out.println("Puppy 멈추었네 ");
	}

}
