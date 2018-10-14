
package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.List;

/**
 * User: blangel
 * Date: 10/14/14
 * Time: 6:47 PM
 */
public class Lists {

    public static <T> List<T> reverse(List<T> list) {
    	List<T> res = new ArrayList<T>();
    	for (T item : list) {
    		res.add(0, item);
    	}
    	return res;
    }
    
}