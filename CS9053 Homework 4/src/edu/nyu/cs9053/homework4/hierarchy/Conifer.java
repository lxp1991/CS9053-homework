package edu.nyu.cs9053.homework4.hierarchy;

public class Conifer extends Tree {
	//Type = Evergreen, isSeedEnclosed = false, isEudicot = N/A
	protected Conifer(String name, Type type, int age, boolean isSeedEnclosed) {
		super(name, Type.Evergreen, age, false);
	}
	
	public static void main(String[] args) {
		Tree t1 = new Avocado("1", 23);
		EudicotOrMonocot t2 = new Avocado("1",23);
		Tree t3 = new Avocado("1", 23);
		EudicotOrMonocot t4 = new Nutmeg("2", 2);
		System.out.println(t2.hashCode());
		System.out.println(t2.equals(t3));
		Object t5 = new Palm("1", 23);

	}
}
