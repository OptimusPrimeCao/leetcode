package HashTable;
import java.util.*;
public class TwoSum {

	public static void main(String[] args) {
        int[] a = {0, 4, 3, 0};
        int[] b ;
        b = new TwoSum().twoSum(a, 0);
        for(int i=0; i<b.length ;i++) {
        	System.out.println(b[i]);
        }
	}
	public int[] twoSum(int[] numbers, int target) {
//		
//		for(int i = 0; i < numbers.length - 1; i++) {
//			for(int j = i + 1; j < numbers.length; j++) {
//				if(numbers[i] + numbers[j] == target) {
//					indices[0] = i + 1;
//					indices[1] = j + 1;
//					break;
//				}
//			}
//			
//		}
//		return indices;
		int[] indices = new int[2];
		int i=0,j=0;
		boolean flag = false;
		
		HashSet<Integer> nums = new HashSet<Integer>();
	    for(i = 0; i < numbers.length && !flag; i++) {
	    	if(numbers[i] * 2 == target) {
	    		 for(j = i + 1; j < numbers.length; j++) 
	    			  if(numbers[j] == numbers[i]) {
	    				    flag = true;
	    					break;
	    			  }
	    	}else {
	    		nums.add(numbers[i]);
	    	}
	    }
	    
	    if(flag) {	   
	    	indices[0] = i;
	    	indices[1] = j + 1;
		    return indices;
	    }
	    
	    for(i = 0; i < numbers.length; i++) {
	    	nums.remove(numbers[i]);
	    	if(nums.contains(target - numbers[i])) {
	    		break;
		    }
	    }
	    		
	    for(j = i + 1; j < numbers.length; j++) {
			if(numbers[j] == target - numbers[i]) {
				break;
			}
	    }
	   
	    
	    
    	indices[0] = i + 1;
    	indices[1] = j + 1;
	    
	    return indices;
		
        
        
    }

}
