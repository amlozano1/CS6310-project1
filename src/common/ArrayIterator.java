package common;

import java.util.Iterator;

public class ArrayIterator implements Iterator<Number> {
	private int i = 1;
	private int j = 1;
	Array_Simulator sim;
	Number[][] plate;
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