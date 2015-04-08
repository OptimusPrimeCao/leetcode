
public class LongestPalindromicSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(LongestPalindromicSubString.longestPalindrome("aa"));

	}
	public static String longestPalindrome(String s) {
		if(s == null || s.length() == 0) 
			return null;
		
		int maxLen = 0;                //最大间距，其实是最大长度-1
		int startIndex = 0;
		int endIndex = 0;
        int len = s.length();
		boolean dp[][] = new boolean[len][len];
		for(int i = 0; i < len; i++) {
			for(int j = 0; j<len; j++) {
				if(i >= j) {
					dp[i][j] = true;
				}else
					dp[i][j] = false;
			}
		}
		
		for(int k = 1; k < len; k++) {
			for(int i = 0; i + k < len; i++) {
				int j = i + k;
				if(s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i+1][j-1];
					if(dp[i+1][j-1]) {
						if(k > maxLen) {
							maxLen = k;
							startIndex = i;
							endIndex = j;	
						}
					}
				}
				else {
					dp[i][j] = false;
				}
			}
		}
		return s.substring(startIndex, endIndex + 1);
    }

}
