package edu.nyu.cs9053.homework9;

public class ArbitratorSolution implements Philosopher {
	
	private final Waiter waiter;
	
	private final String name;
	
	public ArbitratorSolution(String name, Waiter waiter) {
		this.name = name;
		this.waiter = waiter;
	}

	@Override
	public boolean attemptEat(Chopstick left, Chopstick right, Callback callback) {
		boolean isBothFree = waiter.pickedUpChopstick(left, right);
		if (isBothFree) {
			try {
				callback.pickedUpChopstick(left);
				callback.pickedUpChopstick(right);	
			} catch (AssertionError ae) {
				return false;
			}
		}
		return isBothFree;
	}

	@Override
	public void doneEating(Chopstick left, Chopstick right, Callback callback) {
		waiter.putDownChopstick(left, right);
		try {
			if (left != null) {
				callback.putDownChopstick(left);	
			}
			if (right != null) {
				callback.putDownChopstick(right);	
			}
		} catch (Exception e) {
			//will catch any exception
			return;
		}
		
	}

	@Override
	public String getName() {
		return name;
	}
	
}
