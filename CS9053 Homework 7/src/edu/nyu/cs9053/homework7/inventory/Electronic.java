package edu.nyu.cs9053.homework7.inventory;

public class Electronic implements Item {
	
	private final double price;
	
	public Electronic(double price) {
		this.price = price;
	}
	
	@Override
	public Double getPrice() {
		return price;
	}
	
}
