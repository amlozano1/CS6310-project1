/**
 * 
 */
package Tpdahp;
import Tpdahp.Simulator;
import common.SimulatorParams;
import java.lang.Runtime;
/**
 * @author Anthony
 *
 */
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Tpdahp, "); //instrumentation code 
		long startTime = System.currentTimeMillis();
		SimulatorParams params = new SimulatorParams(args);
		Simulator sim = new Simulator(params);
		sim.heat();
		Runtime runtime = Runtime.getRuntime();
		long max_mem = runtime.totalMemory() - runtime.freeMemory();
		long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
	    
		System.out.println(String.format(", %d, %d", elapsedTime, max_mem));
		
//		System.out.print(sim.toString());
	}

}
