package edu.nyu.cs9053.homework9;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: blangel
 * Date: 11/11/14
 * Time: 8:49 AM
 */
public class Waiter {
	
	private enum ChopstickState { FREE, USED};
    
	private static ConcurrentHashMap<Integer, ChopstickState> chopstickMap; 
	private static ChopstickState[] chopstickStates;

	static {
		chopstickStates = new ChopstickState[5];
		chopstickMap = new ConcurrentHashMap<Integer, ChopstickState>(5, 1.0f);
		Arrays.fill(chopstickStates, ChopstickState.FREE);
		chopstickMap.put(1, ChopstickState.FREE);
		chopstickMap.put(2, ChopstickState.FREE);
		chopstickMap.put(3, ChopstickState.FREE);
		chopstickMap.put(4, ChopstickState.FREE);
		chopstickMap.put(5, ChopstickState.FREE);
	}

	public  boolean pickedUpChopstick(Chopstick left, Chopstick right) {
		if (left == null || right == null) {
			throw new IllegalArgumentException();
		}
		
		//Only one can eat at the same time, so if somebody else is eating, others cannot pick up chopstick
		if (!areAllFree()) {
			return false;
		}
		
		int leftNumber = left.getNumberAroundTable();
		int rightNumber = right.getNumberAroundTable();
		if (chopstickMap.get(leftNumber) == ChopstickState.USED || chopstickMap.get(rightNumber) == ChopstickState.USED) {
			return false;
		} else {
			chopstickMap.put(leftNumber, ChopstickState.USED);
			chopstickMap.put(rightNumber, ChopstickState.USED);
			return true;
		}
	}
	
	//Check if all chopsticks are free
	private  boolean areAllFree() {
		for (ChopstickState chopstickState : chopstickMap.values()) {
//			System.out.print(chopstickState + " ");
			if (chopstickState == ChopstickState.USED) {
				return false;
			}
		}
		return true;
	}
	
	public  void putDownChopstick(Chopstick left, Chopstick right) {
		if (left == null || right == null) {
			throw new IllegalArgumentException();
		}
		int leftNumber = left.getNumberAroundTable();
		int rightNumber = right.getNumberAroundTable();
		chopstickMap.put(leftNumber, ChopstickState.FREE);
		chopstickMap.put(rightNumber, ChopstickState.FREE);
	}
	
}