package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: blangel
 * Date: 10/14/14
 * Time: 6:47 PM
 */
public class Sets {


    public static <T> Set<T> union(Set<T> left, Set<T> right) {
    	Set<T> res = new HashSet<T>();
    	res.addAll(left);
   		res.addAll(right);
   		return res;
    }


    public static <T> Set<T> intersection(Set<T> left, Set<T> right) { 
    	Set<T> res = new HashSet<T>();
    	res.addAll(left);
    	if (left == null || right == null)
    		return new HashSet<T>();
    	res.retainAll(right);
    	return res;
    }

    public static <T> Set<T> symmetricDifference(Set<T> left, Set<T> right) {
    	Set<T> union = union(left, right);
    	Set<T> intersection = intersection(left, right);
    	union.removeAll(intersection);
    	return union;
    }

    public static <T> List<Set> cartesianProduct(List<Set> sets) {
    	List<Set> res = new ArrayList<Set>();
    	for (Set<T> setA : sets) {
    		for (Set<T> setB : sets) {
    			if (!setA.equals(setB)) {
    				cartesianProductForTwoSets(setA, setB, res);
    			} 
    		}
    	}
    	return res;
    }
    
    public static <T> void cartesianProductForTwoSets(Set<T> setA, Set<T> setB, List<Set> res) {
    	for (T itemA : setA) {
    		for (T itemB : setB) {
    			if (!itemA.equals(itemB)) {
    				Set<T> curPair = new HashSet<T>() {{;
    				add(itemA);
    				add(itemB);
    				}};
    				if (!res.contains(curPair)) res.add(curPair);
    			} 
    		}
    	}
    }
}