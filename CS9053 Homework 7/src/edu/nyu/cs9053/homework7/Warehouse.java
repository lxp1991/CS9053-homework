package edu.nyu.cs9053.homework7;

import java.util.Iterator;
import edu.nyu.cs9053.homework7.inventory.Item;

/**
 * User: blangel
 * Date: 10/13/14
 * Time: 1:57 PM
 */
public class Warehouse {

    private static void copy(Bin<? extends Item> from, Bin<Item> into) {
	//copy values in 'from' to 'into'
    	Iterator<? extends Item> iterator = from.iterator();
    	while (iterator.hasNext()) {
    		Item object = (Item) iterator.next();
    		into.add(object);
    	}
    }

    //implement such that the warehouse can hold any Bin of Item type

    private final Bin<? extends Item> items;

    public Warehouse(Bin<? extends Item> items) {
        this.items = items;
    }

    public Bin<? extends Item> getItems() {
        return items;
    }

    public Warehouse copy() {
    	Bin<Item> newBin = new Bin<Item>();
    	copy(items, newBin);
    	Warehouse newWarehouse = new Warehouse(newBin); 
    	
        //make a new Bin copying the values from `items` into a new Bin using the 'copy' method below
        //change to return a copied bin
        return newWarehouse;
    }

}