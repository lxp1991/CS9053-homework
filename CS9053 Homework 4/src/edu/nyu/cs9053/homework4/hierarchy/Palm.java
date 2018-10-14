package edu.nyu.cs9053.homework4.hierarchy;

public class Palm extends EudicotOrMonocot {
	//Type = Evergreen, isSeedEnclosed = false, isEudicot = false
	protected Palm(String name, int age) {
		super(name, Type.Evergreen, age, false, false);
	}

}
