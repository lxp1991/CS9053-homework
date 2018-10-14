package edu.nyu.cs9053.homework5;

/**
 * User: blangel
 * Date: 9/21/14
 * Time: 6:01 PM
 */
public class MadScientist {

    private final TimeMachine timeMachine;
    
    //reference: http://stackoverflow.com/questions/434657/java-double-value-comparison
    private static final double EPSILON = 0.0000001d;

    public MadScientist(TimeMachine timeMachine) {
        this.timeMachine = timeMachine;
    }

    public static void main(String[] args) {
    	TimeMachine timeMachine = new TimeMachine();
    	MadScientist madScientist = new MadScientist(timeMachine);
    	TimeTraveler linearTimeTraveler = new LinearDecayTimeTraveler();
    	TimeTraveler doubleTimeTraveler = new DoubleDecayTimeTraveler();
    	TimeTraveler exponentialTimeTraveler = new ExponentialDecalTimeTravel(0.25d);
    	while (hasRemainingYears(linearTimeTraveler, doubleTimeTraveler, exponentialTimeTraveler)) {
    		madScientist.experiment(linearTimeTraveler);
    		madScientist.experiment(doubleTimeTraveler);
    		madScientist.experiment(exponentialTimeTraveler);	
    	}
    }
    
    protected static boolean hasRemainingYears(TimeTraveler ... timeTravelers) {
    	for (TimeTraveler timeTraveler : timeTravelers) {
    		if (timeTraveler == null) 
    			continue;
    		if (timeTraveler.getRemainingYearsOfTravel() >= EPSILON) {
    			return true;
    		}
    	}
    	return false;
    }

    public void experiment(TimeTraveler timeTraveler) {
    	timeMachine.travel(timeTraveler, new TimeTravelCallback() {
    		@Override public void leaped(Time unit, int amount, boolean ahead) {
    			System.out.println(timeTraveler.getName() + " has traveled " + amount + " " + unit + " in the " + (ahead ? "future" : "past"));
    			timeTraveler.adjust(unit, amount, ahead);
    			System.out.println(timeTraveler.getName() + " has " + timeTraveler.getRemainingYearsOfTravel() + " years remaining");
    		}
    	});
        // invoke the time-machine and print how much time has passed using a callback and adjust the time traveler's ability to travel
    }
    


}