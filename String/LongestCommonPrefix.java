package String;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		int endIndex = 0;
		boolean flag = true;
		if(strs == null || strs.length < 1 || strs[0].isEmpty())
			return "";
		while(flag) {
			if(strs[0].length()-1 < endIndex) {
				break;
			}
			char c = strs[0].charAt(endIndex);
			for(int i=1;i<strs.length;i++) {
				String s = strs[i];
				if(s.length()-1 < endIndex) {
					flag = false;
					break;
				}
				
				if(s.charAt(endIndex) != c) {
					flag = false;
					break;
				}
			}
			if(flag)
				endIndex ++;
			
		}
		
		return strs[0].substring(0, endIndex);
		
	}
}
