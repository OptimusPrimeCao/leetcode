package dynamicProgramming;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null && s2 == null)
			return s3 == null;
		if(s1 == null && s2 != null)
			return s2.equals(s3);
		if(s2 == null)
			return s1.equals(s3);
		
		if(s3 == null || s1.length() + s2.length() != s3.length())
			return false;
		
		int m = s1.length()+1;
		int n = s2.length()+1;
		boolean[][] dp = new boolean[m][n];

		boolean flag = true;
		dp[0][0] = true;
		for(int i=1;i<n;i++) {
			if(!flag || s2.charAt(i-1) != s3.charAt(i-1))
				flag = false;
			dp[0][i] = flag;			
		}	

		flag = true;
		for(int i=1;i<m;i++) {
			if(!flag || s1.charAt(i-1) != s3.charAt(i-1))
				flag = false;
			dp[i][0] = flag;			
		}

		for(int i=1;i<m;i++) 
			for(int j=1;j<n;j++) 
				dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1+j))
				|| (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i-1+j)) ;
		return dp[m-1][n-1];
	}
}
