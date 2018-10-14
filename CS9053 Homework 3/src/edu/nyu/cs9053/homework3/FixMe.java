package edu.nyu.cs9053.homework3;

//Import the metadata package so that we can use FixMeToo class 
import edu.nyu.cs9053.homework3.metadata.*;
/**
 * User: blangel
 * Date: 8/23/14
 * Time: 11:45 AM
 */
public class FixMe {
	//Add final modifier 
    private final String name;

    private final String secondary;
    
    private static final boolean DEFAULT_ESCAPE_VALUE_IN_FixMeToo = true;
    

    /**
    * @param s
    * @return true if s is blank or null, otherwise it returns false
    */    
    private static boolean isNullOrBlank(String s)
    {
    	return (s == null || s.trim().equals(""));
    }
    
    public FixMe(String name) {
    	this(name, null);
    }

    public FixMe(String name, String secondary) {
    	if (isNullOrBlank(name)) {
    		throw new IllegalArgumentException();
    	}
    	this.name = name;
        this.secondary = new FixMeToo(DEFAULT_ESCAPE_VALUE_IN_FixMeToo).analyzeMetadata(secondary);
    }
    		
    //This function creates a new object and can be called even if no object has been constructed,
    //so it should be a static method 
    public static FixMe changeName(String name) {
    	if (isNullOrBlank(name)) {
    		throw new IllegalArgumentException();
    	}
    	return new FixMe(name);
    }
    
    public FixMe changeName(String firstName, String lastName) {
    	if (isNullOrBlank(firstName) || isNullOrBlank(lastName))
    		throw new IllegalArgumentException();
    	String fullName = String.format("%s %s", firstName, lastName);
    	return new FixMe(fullName, secondary);
    }

    //Add the getter to access the name
	public String getName() {
		return name;
	}
	
    //Add the getter to access the secondary 
	public String getSecondary() {
		return secondary;
	}


}