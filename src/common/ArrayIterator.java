package common;

import java.util.Iterator;

/**
 * @author Anthony
 * This class implements a common iterator for all Array_Simulators
 */
public class ArrayIterator implements Iterator<Number> {
	/**
	 * Inner loop iterator, begins at one to avoid edges
	 */
	private int i = 1;
	
	/**
	 * Outer loop iterator, begins at one to avoid edges
	 */
	private int j = 1;
	
	/**
	 * The simulator to iterate over
	 */
	Array_Simulator sim;
	
	/**
	 * The simulator's plate will be copied here to iterate over
	 */
	Number[][] plate;
	
	/**
	 * Constructor
	 * @param sim_interface a Array_Simulator to iterate over 
	 */
	public ArrayIterator(Array_Simulator sim_interface) {
		sim = sim_interface;
		plate = sim.getPlate();
	}
	
	public boolean hasNext() {
		return j < sim.dimen-1;
	}
		
	public Number next() {
		Number ret_val = null;
		ret_val = plate[j][i];
		i++;
		if(i >= sim.dimen-1) {
			j++;
			i = 1;
		}
		return ret_val;
	}

	public void remove() {
		// TODO Auto-generated method stub
		
	}
}