package dynamicProgramming;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if((S == null || S.isEmpty()) || (T==null || T.isEmpty()))
			return 0;
		int m = S.length();
		int n = T.length();
		int[][] dp = new int[m][n];
		int sum = 0;
		for(int i=0; i<m;i++) {
			if(S.charAt(i) == T.charAt(0)) 
				sum ++;
			dp[i][0] = sum;
		}
		
		for(int i=1;i<n;i++)
			dp[0][i] = 0;
		
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				if(S.charAt(i) == T.charAt(j))
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[m-1][n-1];
		
		
	}
}
