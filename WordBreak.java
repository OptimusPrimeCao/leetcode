import java.util.*;
public class WordBreak {


	public static void main(String[] args) {
		

	}
	
    public boolean wordBreak(String s, Set<String> dict) {
    	ArrayList<Integer> partitions =new ArrayList<Integer>(); 
    	if(null == s) {
    		return true;
    	}
    	
        for(int i = 0; i < s.length(); i++) {
        	if(dict.contains(s.substring(0, i+1))) {
        		partitions.add(i);
        		
        	}
        	else{
	        	for(int j = partitions.size()-1; j>=0; j-- ) {
	        		String test = s.substring(partitions.get(j) + 1, i + 1);
	        		if(dict.contains(test)) {
	        			partitions.add(i);
	        			break;
	        		}	
	        	}
        	}
        }
        
        if(!partitions.isEmpty() &&( s.length() - 1 == partitions.get(partitions.size() - 1))) 
        	return true;
        else 
        	return false;
    }


}
