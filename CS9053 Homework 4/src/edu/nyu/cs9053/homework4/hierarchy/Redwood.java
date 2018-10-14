package edu.nyu.cs9053.homework4.hierarchy;

public class Redwood extends Tree {
	//Type = Evergreen, isSeedEnclosed = false, isEudicot = N/A
	protected Redwood(String name, int age) {
		super(name, Type.Evergreen, age, false);
	}
}
