package twoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		int start = 0;
		int end = 0;
		int max = 0;
		char[] cArr= s.toCharArray();
		while(end < s.length()) {
			if(!charMap.containsKey(cArr[end])) {
				charMap.put(cArr[end], end);
				end++;
				continue;
			}
			
			max = Math.max(max, end-start);
			int preIndex = charMap.get(cArr[end]);
			while(start <= preIndex) 
				charMap.remove(cArr[start++]);
		}
		return Math.max(max, end-start);
	}
}
