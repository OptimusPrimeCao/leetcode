package dynamicProgramming;

public class DecodeWays {
	public static int numDecodings(String s) {
		if(s == null || s.isEmpty())
			return 0;

		int[] dp = new int[s.length()+1];
		char[] sArr = s.toCharArray();
		dp[0] = 1;
		if(sArr[0] == '0')
			return 0;
		else 
			dp[1] = 1;

		for(int i=2;i<=s.length();i++) {
			if(sArr[i-2] == '1' || (sArr[i-2] == '2' && sArr[i-1]>='0' && sArr[i-1]<='6'))
				dp[i] += dp[i-2];

			if(sArr[i-1] != '0')
				dp[i] += dp[i-1]; 
			else if(dp[i] == 0)
				return 0;

		}

		return dp[s.length()];

	}
	
	public static void main(String[] args) {
		System.out.println(numDecodings("10"));
	}
	
}
