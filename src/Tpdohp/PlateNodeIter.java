package Tpdohp;

import java.util.Iterator;
import Tpdohp.PlateNode;

/**
 * This class implements an iterator for plate nodes. It starts below and to the
 * right of the node that was passed to its constructor.
 * @author Anthony
 *
 */
public class PlateNodeIter implements Iterator<PlateNode> {
	PlateNode row;
	PlateNode current;
	
	PlateNodeIter(PlateNode start) {
		current = start.below;
		row = current;
	}

	@Override
	public boolean hasNext() {
		if(current.right.is_right_edge && current.below.is_bottom_edge){
			return false;
		}
		return true;
	}

	@Override
	public PlateNode next() {
		if(current.right.is_right_edge && current.below.is_bottom_edge) {
			return null;
		}
		else if(current.right.is_right_edge)
		{
			current = row.below;
			row = current;
			current = current.right;
			return current;
		}
		else
		{
			current = current.right;
			return current;
		}
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}