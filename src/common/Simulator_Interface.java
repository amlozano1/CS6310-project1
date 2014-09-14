package common;

public interface Simulator_Interface {

	/**
	 * heats the plate once, updating all values to the value they would have on
	 * 	the next iteration of a heating simulation.
	 * @param delta If any cell changes by more than this amount, this method returns True
	 * @return whether or not any cell changed by more than delta
	 */
	public abstract boolean heat_once(double delta);
}
