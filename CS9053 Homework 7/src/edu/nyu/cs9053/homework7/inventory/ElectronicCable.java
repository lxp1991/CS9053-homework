package edu.nyu.cs9053.homework7.inventory;

public class ElectronicCable <T extends Electronic> implements Item {

	private final double price;
	
	private final T cable;
	
	public ElectronicCable(double price, T cable) {
		this.price = price;
		this.cable = cable;
	}
	
	@Override
	public Double getPrice() {
		return price;
	}

	public T getCable() {
		return cable;
	}
	

}
