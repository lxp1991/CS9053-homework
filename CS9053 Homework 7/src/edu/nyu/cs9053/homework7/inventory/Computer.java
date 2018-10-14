package edu.nyu.cs9053.homework7.inventory;

public class Computer extends Electronic implements Item {
	
	private final double price;
	
	private final double ghz;
	
	public Computer(double price, double ghz) {
		super(price);
		this.price = price;
		this.ghz = ghz;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}
	
}
