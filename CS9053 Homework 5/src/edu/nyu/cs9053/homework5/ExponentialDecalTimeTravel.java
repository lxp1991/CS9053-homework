package edu.nyu.cs9053.homework5;

public class ExponentialDecalTimeTravel extends AbstractTimeTraveler implements TimeTraveler {
	
	private final double decayConstant;
	
	public ExponentialDecalTimeTravel(double decayConstant) {
		super("Exponential Traveler");
		this.decayConstant = decayConstant;
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
		timePassed = calculateExponentialDecay(AbstractTimeTraveler.DEFAULT_TRAVEL_TIME, decayConstant, timePassed);
		RemainingYearsOfTravel = timePassed;
	}
	
	private double calculateExponentialDecay(double initialValue, double decayConstant, double timePassed) {
		double currentValue = initialValue * Math.exp(-decayConstant * timePassed);
		return currentValue;
		//N(t) = N(0) * e^(-lambda * t),
	}
	
}
