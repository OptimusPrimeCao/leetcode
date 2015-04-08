package BackTracking;

public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		if(s==null || p==null)
			return (p==null) == (s==null);
		if(p.isEmpty())
			return s.isEmpty();
		if(p.length()==1) 
			if(s.length() == 1)
				return p.charAt(0)=='.' || p.charAt(0)==s.charAt(0);
			else
				return false;
		if(p.charAt(1) == '*') {
			if(isMatch(s, p.substring(2)))
				return true;
			int i = 0;
			while(i<s.length() && (p.charAt(0)=='.' || s.charAt(i)==p.charAt(0))) {
				if(isMatch(s.substring(i+1), p.substring(2)))
					return true;
				i++;
			}
			return false;

		}
		else 
			return !s.isEmpty() && (p.charAt(0)=='.' || p.charAt(0)==s.charAt(0)) && isMatch(s.substring(1), p.substring(1));

	}

	public static void main(String[] args) {
//		System.out.println("s".substring(1).isEmpty());
		System.out.println(isMatch("a", ".*..a*"));
	}
}
