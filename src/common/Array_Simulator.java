package common;

import java.util.Iterator;

/**
 * @author Anthony
 * This is the parent class for all simulators that store their lattice as a two
 * dimensional array.s
 */
public class Array_Simulator extends Simulator_Interface {

	/**
	 * plate doesn't have to be a "Double", you can override this but we do 
	 * need a Double[][] so that Array_iter knows it can fetch from it.
	 */
	protected Number[][] plate;
	
	/**
	 * get the plate as an array of Number objects, used for iterators and
	 * toString, but NOT in simulation logic.
	 * @return the plate as an array of Number objects.
	 */
	public Number[][] getPlate() {
		return plate;
	}
	
	public Iterator<Number> iterator() {
		return new ArrayIterator(this);
	}


}
