package edu.nyu.cs9053.homework9;

public class DijkstraSolution implements Philosopher {

	private final String name;
	
	public DijkstraSolution(String name) {
		this.name = name;
	}
	
	@Override
	public boolean attemptEat(Chopstick left, Chopstick right, Callback callback) {
		//Dijkstra's solution is to first pick the lower of the two chopsticks
		if (left.getNumberAroundTable() > right.getNumberAroundTable()) {
			try {
				callback.pickedUpChopstick(right);
				callback.pickedUpChopstick(left);	
			} catch (AssertionError ae) {
				return false;
			}
			
		} else {
			try {
				callback.pickedUpChopstick(left);
				callback.pickedUpChopstick(right);	
			} catch (AssertionError ae) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void doneEating(Chopstick left, Chopstick right, Callback callback) {
		//The order in which each philosopher puts down the chopstick does not matter
		//https://en.wikipedia.org/wiki/Dining_philosophers_problem
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
