package edu.nyu.cs9053.homework5;

public abstract class AbstractTimeTraveler implements TimeTraveler {
	
	public static final double DEFAULT_TRAVEL_TIME = 100d;
	
	private static final double DAYS_IN_ONE_YEAR = 365d;
	
	private static final double HOURS_IN_ONE_YEAE = 365d * 24d;
	
	private final String Name;
	
	protected double RemainingYearsOfTravel;
	
	protected static final double EPSILON = 0.0000001d;
	
	public AbstractTimeTraveler(String Name) {
		this.Name = Name;
		this.RemainingYearsOfTravel = DEFAULT_TRAVEL_TIME;
	}
	
	@Override
	public String getName() {
		return Name;
	}

	@Override
	public Double getRemainingYearsOfTravel() {
		return RemainingYearsOfTravel;
	}

	@Override
	public abstract void adjust(Time unit, int amount, boolean ahead);
	
	/**
	 * @param unit of time
	 * @param amount of time
	 * @return total time loss before any decay (unit: year)
	 */
	public Double calculateTimeLossBeforeDecay(Time unit, int amount) {
		double timeLoss = 0d;
		if (unit == Time.Days) {
			timeLoss = amount / DAYS_IN_ONE_YEAR;
		} else {
			timeLoss = amount / HOURS_IN_ONE_YEAE;
		}
		
		return timeLoss;
	}
	
}
