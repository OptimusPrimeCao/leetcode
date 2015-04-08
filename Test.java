import java.util.Iterator;
import java.util.Map;





public class Test {
	public static void main(String [] args){
		System.out.println("asdad");
		/*configLog();
		String serverroutingkey = "#.simulator";
		String sourceId = "simulator";
		Simulator simulator = new Simulator(serverroutingkey, sourceId);*/
		
		//simulator.run();
	}
        public void run() {
        	System.out.println("abc");
        	new Thread(new Worker()).start();
        }
        private class Worker implements Runnable {
        	public void run() {
        	    while(true) {
        	    	System.out.println("cao");
        	    }}}
}
 

