import java.util.*;
public class WordBreakII {
	HashMap<Integer,ArrayList<Integer>> getPartitions =new HashMap<Integer,ArrayList<Integer>>();
	ArrayList<String> strings = new ArrayList<String>();
	
	 public static void main(String[] args) {
		 Set<String> dict = new HashSet<String>();
		 dict.add("aaaa");
		 dict.add("aa");
		 dict.add("a");
		 WordBreakII wb = new WordBreakII();
		 ArrayList<String> a = wb.wordBreak("aaaaaaa", dict);
		 System.out.println(wb.getPartitions.keySet());
		 System.out.println(wb.getPartitions.entrySet());
		 System.out.println(a);
		 
	 }
	
	
	
	 public ArrayList<String> wordBreak(String s, Set<String> dict) {
		 ArrayList<Integer> partitions =new ArrayList<Integer>(); 
	    	
	        for(int i = 0; i < s.length(); i++) {
	        	ArrayList<Integer> iPartitions;
	        	if(dict.contains(s.substring(0, i+1))){
	        		partitions.add(i);
	        		iPartitions = new ArrayList<Integer>();
	        		iPartitions.add(-1);
	        	    getPartitions.put(i,iPartitions);
	        	}
	        	
	        	for(int j = partitions.size()-1; j>=0; j-- ) {
	        		String test = s.substring(partitions.get(j) + 1, i + 1);
	        		if(dict.contains(test)) {		        			
	        			if(!partitions.contains(i)) {
		        			partitions.add(i);
		        			iPartitions = new ArrayList<Integer>();
			        		iPartitions.add(partitions.get(j));
			        	    getPartitions.put(i,iPartitions);
	        			}
	        			else {
	        				getPartitions.get(i).add(partitions.get(j));
	        			}
	        		}	
	        	}
        	}
	        
	        
	        if(!partitions.isEmpty() &&( s.length() - 1 == partitions.get(partitions.size() - 1))) {
	              dfs(s, "", s.length()-1, getPartitions);        	  
	        }   
	         return strings; 
	         
	  }
	  private void dfs(String s, String str, int pos, HashMap<Integer,ArrayList<Integer>> getPartitions) {
		      
			  ArrayList<Integer> partitions= getPartitions.get(pos);
			  for(int i = partitions.size()-1; i>=0; i--) {
				  if(partitions.get(i) != -1) {
					  if(!str.equals("")){
						  String ss = s.substring(partitions.get(i)+1, pos+1) + " " + str;
					      dfs(s, ss , partitions.get(i), getPartitions);
					  }
					  else {
						  String ss = s.substring(partitions.get(i)+1, pos+1);
					      dfs(s, ss , partitions.get(i), getPartitions);
					  }
				  }
				  else {
					  if(!str.equals("")) 
						  strings.add(s.substring(0, pos+1) + " " + str);
					  else
						  strings.add(s.substring(0, pos+1));
				  }
			  }    
          		  
	  }
	 
	 
	 
	 
}
