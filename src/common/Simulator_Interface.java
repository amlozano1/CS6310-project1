package common;

import java.util.Iterator;

interface SimulatorIterator extends java.util.Iterator<Double> {};

public class Simulator_Interface implements SimulatorIterator, Iterable{

	protected int dimen;
	/**
	 * Must override this
	 * heats the plate once, updating all values to the value they would have on
	 * 	the next iteration of a heating simulation.
	 * @param delta If any cell changes by more than this amount, this method returns True
	 * @return whether or not any cell changed by more than delta
	 */
	public boolean heat_once(double delta) {return true;};

	/**
	 * Returns a string representation of the plate, not including the edges.
	 */
	public String toString(){
		String as_string = "";
		Iterator<Double> iter = this.iterator();
		int row_pos = 1; // iter starts from column '1' 
		while(iter.hasNext()) {
			Double value = iter.next();
			as_string += String.format("%2.2f", value);
			if(dimen-2 <= row_pos) { //dimen-2 is the size of the inner plate
				row_pos = 1; // iter starts from column '1' 
				as_string += '\n';
			}
			else {
				row_pos++;
				as_string += '\t';
			}
		}
		return as_string;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Double> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
