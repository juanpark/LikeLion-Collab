package com.sec06;

public class Tv {
	private String name;
	private int price;
	private String description;

	// needed when there is a constructor
	public Tv() {};

	// Constructor
	public Tv(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Tv [getName()=%s, getPrice()=%s, getDescription()=%s]", getName(), getPrice(),
				getDescription());
	}
	
}
