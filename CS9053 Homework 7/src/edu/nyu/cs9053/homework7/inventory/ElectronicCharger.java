package edu.nyu.cs9053.homework7.inventory;

public class ElectronicCharger <T extends Electronic>  implements Item {
	
	private final double price;
	
	private final T charger;
	
	public ElectronicCharger(double price, T charger) {
		this.price = price;
		this.charger = charger;
	}
	
	@Override
	public Double getPrice() {
		return price;
	}

	public T getCharger() {
		return charger;
	}
	

}
