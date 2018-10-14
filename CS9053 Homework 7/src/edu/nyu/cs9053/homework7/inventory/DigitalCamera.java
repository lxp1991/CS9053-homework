package edu.nyu.cs9053.homework7.inventory;

public class DigitalCamera extends Camera implements Item {
	
	private final double price;
	
	private final int zoom;
	
	public DigitalCamera(double price, int zoom) {
		super(price);
		this.price = price;
		this.zoom = zoom;
	}
	
	@Override
	public Double getPrice() {
		return this.price;
	}

}
