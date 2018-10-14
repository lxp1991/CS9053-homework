package edu.nyu.cs9053.homework7.inventory;

public class Bookmark <T extends Book> implements Item {
	
	private final double price;
	
	private final T bookmark;

	public Bookmark(double price, T bookmark) {
		this.price = price;
		this.bookmark = bookmark;
	}
	
	@Override
	public Double getPrice() {
		return price;
	}

	public T getBookmark() {
		return bookmark;
	}
	
	

}
