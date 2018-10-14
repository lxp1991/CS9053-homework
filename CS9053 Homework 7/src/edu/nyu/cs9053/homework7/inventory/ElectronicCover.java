package edu.nyu.cs9053.homework7.inventory;

public class ElectronicCover <T extends Electronic> implements Item {
	
	private final double price;
	
	private final T electronicCover;
	
	public ElectronicCover(double price, T electronicCover) {
		this.price = price;
		this.electronicCover = electronicCover;
	}
	
	@Override
	public Double getPrice() {
		return price;
	}

	public T getElectronicCover() {
		return electronicCover;
	}
	
}
