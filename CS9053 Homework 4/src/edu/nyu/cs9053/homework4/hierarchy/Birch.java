package edu.nyu.cs9053.homework4.hierarchy;

public class Birch extends EudicotOrMonocot{
	//Type = Deciduous, isSeedEnclosed = false, isEudicot = true
	public Birch(String name, int age) {
		super(name, Type.Deciduous, age, false, true);
	}
}
