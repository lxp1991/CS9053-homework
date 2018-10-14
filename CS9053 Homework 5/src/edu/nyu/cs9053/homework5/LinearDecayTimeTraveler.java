package edu.nyu.cs9053.homework5;

public class LinearDecayTimeTraveler extends AbstractTimeTraveler implements TimeTraveler {

	public LinearDecayTimeTraveler() {
		super("Linear Traveler");
	}

	@Override
	public void adjust(Time unit, int amount, boolean ahead) {
		if (amount < 0) 
			throw new IllegalArgumentException();
		if (RemainingYearsOfTravel < EPSILON) {
			RemainingYearsOfTravel = 0d;
			return;
		}
		double timePassed = calculateTimeLossBeforeDecay(unit, amount);
		RemainingYearsOfTravel = (timePassed >= RemainingYearsOfTravel) ? 0d : RemainingYearsOfTravel - timePassed;
	}
}
