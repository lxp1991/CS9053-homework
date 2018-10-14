package edu.nyu.cs9053.homework4.hierarchy;

public class Camphor extends EudicotOrMonocot {
	//Type = Evergreen, isSeedEnclosed = false, isEudicot = true 
	protected Camphor(String name, int age) {
		super(name, Type.Evergreen, age, false, true);
	}
	
	
}
