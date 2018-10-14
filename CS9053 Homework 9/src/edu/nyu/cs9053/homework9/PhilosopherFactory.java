package edu.nyu.cs9053.homework9;

/**
 * User: blangel
 * Date: 11/11/14
 * Time: 8:31 AM
 */
public class PhilosopherFactory {

    public static Philosopher construct(final String name) {
        Philosopher dijkstraSolution = new DijkstraSolution(name);
    	return dijkstraSolution;
    }

    public static Philosopher constructWithWaiter(final Waiter waiter, final String name) {
        Philosopher arbitratorSolution = new ArbitratorSolution(name, waiter);
        return arbitratorSolution;
    }

    public static Waiter constructWaiter() {
        Waiter waiter = new Waiter();
        return waiter;
    }

}