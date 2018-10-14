package edu.nyu.cs9053.homework5;

public class DoubleDecayTimeTraveler extends AbstractTimeTraveler implements TimeTraveler {

	public DoubleDecayTimeTraveler() {
		super("Double Traveler");
	}

	@Override
	public void adjust(Time unit, int amount, boolean ahead) {
		if (amount < 0) 
			throw new IllegalArgumentException();
		if (RemainingYearsOfTravel < EPSILON) {
			RemainingYearsOfTravel = 0d;
			return;
		}
		double timePassed = calculateTimeLossBeforeDecay(unit, amount) * 2;
		RemainingYearsOfTravel = (timePassed >= RemainingYearsOfTravel) ? 0d : RemainingYearsOfTravel - timePassed;
	}

}
