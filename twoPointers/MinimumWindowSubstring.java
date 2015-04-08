package twoPointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if(S == null || T == null || T.length() > S.length())
			return "";
		
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(int i=0;i<T.length();i++) {
			if(!charMap.containsKey(T.charAt(i))) 
				charMap.put(T.charAt(i), 1);
			else 
				charMap.put(T.charAt(i), charMap.get(T.charAt(i))+1);
		}
		
		char[] cArr = S.toCharArray();
		int start = 0;
		int end ;	
		int count = 0;
		int minLen = Integer.MAX_VALUE;
		String minStr = ""; 
		for(end = 0; end<S.length(); end++) {
			if(!charMap.containsKey(cArr[end]))
				continue;
			if(charMap.get(cArr[end]) > 0) {
				count++;
			}
			charMap.put(cArr[end], charMap.get(cArr[end])-1);
			if(count == T.length()) {
				while(!charMap.containsKey(cArr[start]) || charMap.get(cArr[start]) < 0) {
					if(charMap.containsKey(cArr[start])) 		
						charMap.put(cArr[start],charMap.get(cArr[start])+1);					
					start++;
				}
				if(end-start+1 < minLen) {
					minLen = end-start+1;
					minStr = S.substring(start,end+1);
				}
			}
		}
		return minStr;
	}
	
	public String timeLimit(String S, String T) {
		if(S == null || T == null || T.isEmpty() || S.isEmpty())
			return "";
		
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(int i=0;i<T.length();i++) {
			if(!charMap.containsKey(T.charAt(i))) 
				charMap.put(T.charAt(i), 1);
			else 
				charMap.put(T.charAt(i), charMap.get(T.charAt(i))+1);
		}
		
		char[] cArr = S.toCharArray();
		int start = 0;
		int end = 0;	
		int minLen = Integer.MAX_VALUE;
		String minStr = ""; 
		while(end < S.length()) {
			Map<Character, Integer> testMap = new HashMap<Character, Integer>(charMap);
			int k = start;
			while(k < S.length()){
				if(testMap.containsKey(cArr[k])) {
					if(testMap.get(cArr[k]) != 1)
						testMap.put(cArr[k], testMap.get(cArr[k])-1);
					else
						testMap.remove(cArr[k]);
				}
				if(testMap.size() == 0)
					break;
				k++;

			}
			if(k == S.length())
				break;
			
			end = k;
			testMap = new HashMap<Character, Integer>(charMap);
			while(k >= start){
				if(testMap.containsKey(cArr[k])) {
					if(testMap.get(cArr[k]) != 1)
						testMap.put(cArr[k], testMap.get(cArr[k])-1);
					else
						testMap.remove(cArr[k]);
				}
				if(testMap.size() == 0)
					break;
				k--;

			}
			if(end-k+1 < minLen) {
				minLen = end-k+1;
				minStr = S.substring(k,end+1);
				start = k+1;
			}
			else
				start = end+1;
			
		}
		return minStr;


	}
}
