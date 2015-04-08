package String;

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		if(s == null)
			return 0;
		s = s.trim();
		int i;
		for(i=s.length()-1;i>=0;i--) {
			if(s.charAt(i) == ' ')
				break;
		}
		if(i == -1)
			return s.length();
		return s.length()-i-1;

	}
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("b a "));
	}
}
