package BackTracking;

import java.util.Stack;

public class WildcardMatching {
	public static boolean isMatchTLE(String s, String p) {
		if(s==null || p==null)
			return (p==null) == (s==null);
		if(p.isEmpty())
			return s.isEmpty();
		if(p.charAt(0) == '*') {
			int k=0;
			while(k<p.length() && p.charAt(k)=='*')
				k++;
			int i = 0;
			while(i<s.length()) {
				if(isMatchTLE(s.substring(i), p.substring(k)))
					return true;
				i++;
			}
			return isMatchTLE(s.substring(i),  p.substring(k));

		}
		else 
			return !s.isEmpty() && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0)) && isMatchTLE(s.substring(1), p.substring(1));
	}
	public static void main(String[] args) {
		System.out.println(isMatch("b", "?*?"));
	}
	public static boolean isMatch(String s, String p) {
		if(s==null || p==null)
			return (p==null) == (s==null);
		if(p.isEmpty())
			return s.isEmpty();
		String[] strs = p.split("\\*");
		if(strs.length == 0)
			return true;
		if(s.length()==0)
			return false;
		boolean hasPostWord = true;
		if(p.charAt(p.length()-1)=='*')
			hasPostWord = false;

		String curStr = strs[0];

		int i=0;
		if(!curStr.isEmpty())
			for(i=0;i<curStr.length();i++) {
				if(i==s.length() || (curStr.charAt(i)!='?' && s.charAt(i) != curStr.charAt(i)))
					return false;
			} 
		if(strs.length==1) 
			return i==s.length() || !hasPostWord;

		int start = i;



		curStr = strs[strs.length-1];

		if(hasPostWord) {
			for(i=curStr.length()-1;i>=0;i--) {
				if(s.length()-curStr.length()+i==-1 || (curStr.charAt(i)!='?' && s.charAt(s.length()-curStr.length()+i) != curStr.charAt(i)))
					return false;
			}
			if(start > s.length()-curStr.length())
				return false;
			s = s.substring(start, s.length()-curStr.length());
		}
		else
			s = s.substring(start);


		start = 0;
		int endIndex = hasPostWord?strs.length-1:strs.length;
		for(int k=1;k<endIndex;k++) {
			int j=0;
			curStr = strs[k];			
			i = start;
			while(i<s.length() && j<curStr.length()) {
				if(curStr.charAt(j)=='?'|| s.charAt(i)==curStr.charAt(j)) {
					i++;
					j++;
				}
				else {
					i = start + 1;
					start++;
					j = 0;
				}

			}
			if(i>=s.length()) {
				if(j == curStr.length()) {
					k++;
					while(k<endIndex && strs[k].isEmpty())
						k++;
					if(k==endIndex)
						return true;
				}
				return false;				
			}

			start = i;
		}

		return true;	
	}





}
