import java.util.*;


public class LongestConsecutiveNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestConsecutive(int[] num) {
        Set<Integer> nums = new HashSet<Integer>();
       
        int longestLen = 0;
        for(int i = 0; i < num.length; i++) {
        	nums.add(num[i]);
        }
        for(int i = 0; i< num.length; i++) {
        	int tmpLen = 1;
        	if(nums.contains(num[i])) { 		
	        	nums.remove(num[i]);
	        	int n = num[i] + 1;
	        	while(nums.contains(n)) {
	        		tmpLen ++;
	        		nums.remove(n);
	        		n++;
	        	}
	        	n = num[i] - 1;
	        	while(nums.contains(n)) {
	        		tmpLen ++;
	        		nums.remove(n);
	        		n--;
	        	}
	        	if(tmpLen > longestLen) {
	        		longestLen = tmpLen;
	        	}
        	}
        }
        return longestLen;
	}

}
