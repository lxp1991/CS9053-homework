package edu.nyu.cs9053.homework7.inventory;

import java.util.ArrayList;

public class Bookcase <T extends Book> implements Item {

	private final double price;
	
	private final ArrayList<T> books;
	
	public Bookcase(double price, ArrayList<T> books) {
		this.price = price;
		this.books = new ArrayList<T>(books);
	}
	
	@Override
	public Double getPrice() {
		return price;
	}

	public ArrayList<T> getBooks() {
		return books;
	}

		
}
