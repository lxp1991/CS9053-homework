package edu.nyu.cs9053.homework4.hierarchy;

public class EudicotOrMonocot extends Tree {

	private final boolean isEudicot;
	
	protected EudicotOrMonocot(String name, Type type, int age, boolean isSeedEnclosed, boolean isEudicot) {
		super(name, type, age, isSeedEnclosed);
		this.isEudicot = isEudicot;
	}
	
	public boolean isEudicot() {
		return isEudicot;
	}

}
