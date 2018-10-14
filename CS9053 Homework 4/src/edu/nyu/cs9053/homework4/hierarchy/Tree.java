package edu.nyu.cs9053.homework4.hierarchy;

/**
 * @author lxp1991
 *
 */

public abstract class Tree {
	
	private final boolean isSeedEnclosed;
	
	private final Type type;
	
	private final String name;
	
	private final int age;
	
	protected Tree(String name, Type type, int age, boolean isSeedEnclosed) {
		this.name = name;
		this.type = type;
		this.age = age;
		this.isSeedEnclosed = isSeedEnclosed;
	}
	
	@Override 
	public boolean equals(Object o) {
		//reflexive
		if (this == o)
			return true;
		
		if (o == null || getClass() != o.getClass())
			return false;
		
		Tree that = (Tree) o;
		return this.name == null ? that.name == null : this.name.equals(that.name)
				&& that.type == this.type 
				&& that.age == this.age;
	}
	
	
	//reference: http://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
	@Override 
	public int hashCode() {
		int result = 5;
		//only include age, name, type
		result = 37 * result + age + ((name == null) ? 0 : name.hashCode()) + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @return the isSeedEnclosed
	 */
	public boolean isSeedEnclosed() {
		return isSeedEnclosed;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}






}
