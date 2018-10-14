package edu.nyu.cs9053.homework4.hierarchy;

public class Avocado extends EudicotOrMonocot {
	//Type = Evergreen, isSeedEnclosed = true, isEudicot = true  
	protected Avocado(String name, int age) {
		super(name, Type.Evergreen, age, true, true);
	}
}
