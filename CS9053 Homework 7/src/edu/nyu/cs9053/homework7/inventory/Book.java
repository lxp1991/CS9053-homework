package edu.nyu.cs9053.homework7.inventory;

public class Book implements Item {
	
	protected final String title;

	protected final double price;
	
	public Book(String title, double price) {
		this.title = title;
		this.price = price;
	}
	
	@Override
	public Double getPrice() {
		return this.price;
	}
	
}
