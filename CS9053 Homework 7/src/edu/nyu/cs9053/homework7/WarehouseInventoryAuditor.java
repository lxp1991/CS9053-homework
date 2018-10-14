package edu.nyu.cs9053.homework7;

import edu.nyu.cs9053.homework7.inventory.*;

/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:58 PM
 */
public class WarehouseInventoryAuditor {
		
    //create a method to print the individual prices of a Bin of any Item type
	public static void printItem(Warehouse itemsHouse) {
		if (itemsHouse == null) 
			throw new IllegalArgumentException();
		Bin<? extends Item> bin = itemsHouse.getItems();
		try {
			for (Item item: bin) {
				System.out.println(item.getPrice());	
			}
		} catch (ClassCastException e) {
			System.out.println("Incompatible type error, expected type: Item");
		}
	}
		
    //create a method to print the individual prices of a Bin of any Electronic types
	public static void printElectronic(Warehouse electronicsHouse) {
		if (electronicsHouse == null) 
			throw new IllegalArgumentException();
		Bin<Electronic> bin = (Bin<Electronic>) electronicsHouse.getItems();
		try {
			for (Electronic item: bin) {
				System.out.println(item.getPrice());	
			}
		} catch (ClassCastException e) {
			System.out.println("Incompatible type error, expected type: Electronic");
		}
	}
		
    //create a method to print the individual prices of a Bin of any Book types
	public static void printBook(Warehouse bookHouse) {
		if (bookHouse == null) 
			throw new IllegalArgumentException();
		Bin<Book> bin = (Bin<Book>) bookHouse.getItems();		
		try {
			for (Book item: bin) {
				System.out.println(item.getPrice());	
			}
		} catch (ClassCastException e) {
			System.out.println("Incompatible type error, expected type: Book");
		}
	}
} 