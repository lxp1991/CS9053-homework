package edu.nyu.cs9053.homework4.hierarchy;

public class Cycad extends Tree {
	//Type = Evergreen, isSeedEnclosed = true, isEudicot = N/A
	protected Cycad(String name, int age) {
		super(name, Type.Evergreen, age, true);
	}

}
