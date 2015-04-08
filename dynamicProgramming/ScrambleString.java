package dynamicProgramming;

public class ScrambleString {
	public static boolean isScramble(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;

		int len = s1.length();
		if(len == 0)
			return true;
		if(len == 1 && s1.charAt(0) == s2.charAt(0))
			return true;

		for(int i=1;i<len;i++) {
			boolean flag = (isScramble(s1.substring(0, i), s2.substring(len-i)) && 
					isScramble(s1.substring(i), s2.substring(0, len-i))) ||
					(isScramble(s1.substring(0, i), s2.substring(0, i)) && 
							isScramble(s1.substring(i), s2.substring(i)));
			if(flag)
				return true;
		}

		return false;	
	}
	
	public static boolean isScramble2(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		int len = s1.length();
		boolean[][][] dp = new boolean[len][len][len];
		
		for(int i=0;i<len;i++)
			for(int j=0;j<len;j++)
				dp[i][j][0] = s1.charAt(i)==s2.charAt(j);
		

		for(int k=2;k<=len;k++)
			for(int i=0;i<=len-k;i++)
				for(int j=0;j<=len-k;j++) {
					boolean flag = false;
					for(int m=1;m<k && !flag;m++) {
						flag = (dp[i][j+k-m][m-1] && dp[i+m][j][k-m-1]) || (dp[i][j][m-1] && dp[i+m][j+m][k-m-1]);
					}
					dp[i][j][k-1] = flag; 

				}
		return dp[0][0][len-1];

	}



	public static void main(String[] args) {
		System.out.println(isScramble("aa", "aa"));
		System.out.println(isScramble2("aa","aa"));
	}
}


