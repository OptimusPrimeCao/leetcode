package twoPointers;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if(s==null)
			return true;
		s = s.trim();
		s = s.toLowerCase();
		int start = 0;
		int end = s.length()-1;
		while(start < end) {
			if((s.charAt(start)<'a' || s.charAt(start)>'z') && (s.charAt(start)<'0' || s.charAt(start)>'9')) {
				start++;
				continue;
			}
			if((s.charAt(end)<'a' || s.charAt(end)>'z') && (s.charAt(end)<'0' || s.charAt(end)>'9')) {
				end--;
				continue;
			}
			if(s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			}
			else
				break;
		}
		if(start >= end)
			return true;
		return false;
		
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome("1a2"));
	}
}
