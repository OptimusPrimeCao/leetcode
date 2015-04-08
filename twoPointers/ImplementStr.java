package twoPointers;

public class ImplementStr {
	public static int strStr(String haystack, String needle) {
		if(needle == null || needle.isEmpty())
			return 0;
		int[] next = new int[needle.length()];
		getNext(needle,next);
		int i = 0;
		int j = 0;
		char[] mainArr = haystack.toCharArray();
		char[] modelArr = needle.toCharArray();
		while(i<haystack.length() && j<needle.length()) {
			if(j==-1 || modelArr[j] == mainArr[i]) {
				i++;j++;
			}
			else
				j = next[j];
		}
		
		if(j < needle .length())
			return -1;
		return i-needle.length();
		
	}
	
	public static void getNext(String s, int[] next) {
		next[0] = -1;
		int i = 0;
		int j = -1;
		char[] cArr = s.toCharArray();
		while(i<next.length-1) {
			if(j == -1 || cArr[j] == cArr[i]) {
				i++;j++;
				if(cArr[i] != cArr[j])
					next[i] = j;
				else
					next[i] = next[j];
			}
			else
				j = next[j];
		}
		for(int t=0;t<next.length;t++)
			System.out.println(next[t]);
	}
	
	public static void main(String[] args) {
		System.out.println(strStr("bba", "a"));
		
	}
	                                       
	
	
	
}
