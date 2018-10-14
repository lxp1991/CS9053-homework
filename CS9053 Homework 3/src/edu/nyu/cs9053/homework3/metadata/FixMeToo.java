package edu.nyu.cs9053.homework3.metadata;

/**
 * User: blangel
 * Date: 8/23/14
 * Time: 11:56 AM
 */
//add public to make it visible to others
public class FixMeToo {

    private final boolean escape;

    public FixMeToo(boolean escape) {
        this.escape = escape;
    }

    public String analyzeMetadata(String metadata) {
    	if (metadata == null || metadata.isEmpty())
    		throw new IllegalArgumentException();
    	//Change %d to %s, because metadata is a string
        return escape ? String.format("\"%s\"", metadata) : metadata;
    }

}
