package greedy;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int gasInCar = 0;
		int n = gas.length;
		
		int i = 0;
		int end = 0;
		int start = 0;
		for(int count=0;count<n;count++) {
			gasInCar += gas[i] - cost[i];
			if(gasInCar >= 0) {
				end++;
				i = end;
			}
			else {
				if(start == 0)
					start = n-1;
				else
					start --;
				i = start;
			}
		}
		
		if(gasInCar < 0)
			return -1;
		return start;
		
		
	}
}
