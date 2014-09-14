package common;

import java.util.Iterator;

public class Array_Simulator extends Simulator_Interface implements Iterable{

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
	
	public Iterator<Double> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator(this);
	}


}
