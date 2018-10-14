package edu.nyu.cs9053.homework4.hierarchy;

public class Nutmeg extends EudicotOrMonocot {
	//Type = Evergreen, isSeedEnclosed = true, isEudicot = true
	protected Nutmeg(String name, int age) {
		super(name, Type.Evergreen, age, true, true);
	}

}
