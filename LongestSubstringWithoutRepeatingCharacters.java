//  Ëã·¨
import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {

	
	public static void main(String[] args) {
		String s = "";
		int n = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
		System.out.println(n);
	}
	
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> indexs = new HashMap<Character, Integer>(); 
		if(s == null || s == "") {
			return 0;			
		}
		

		int idx = -1;
		int max = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(indexs.containsKey(ch)&& indexs.get(ch) > idx) {
				idx = indexs.get(ch);
			}
				
			if(i - idx > max) {
				max = i - idx;	
			}
			
			indexs.put(ch, i);
			
		}
		return max;
	}

}
