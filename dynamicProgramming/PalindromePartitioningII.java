package dynamicProgramming;

public class PalindromePartitioningII {
	
	public static int minCut(String s) {
		if(s==null || s.length()==0)
			return 0;
		int len = s.length();
		boolean[][]palindromeMap = new boolean[len][len];
		getPalindromeMap(s, palindromeMap);
		int[][] min = new int[len][len];
		for(int i=len-1;i>=0;i--) {
			for(int j=i;j<len;j++) {
				int minCut = len;
				if(i==j || palindromeMap[i][j])
					minCut = 0;
				else {
					for(int k=i;k<j;k++) {
						if(palindromeMap[i][k] && min[k+1][j]<minCut)
							minCut = min[k+1][j];
					}
					minCut = minCut+1;
				}
				min[i][j] = minCut;
			}
		}

		return min[0][len-1];

	}

	public static int minCut2(String s) {
		if(s == null || s.length() == 0)
			return 0;
		boolean palin[][] = new boolean[s.length()][s.length()];
		int minCutArray[] = new int[s.length()];
		for(int i = s.length()-1; i>=0; i--) {
			minCutArray[i] = s.length()-i-1 ;
			for(int j = i; j < s.length(); j++) {
				if(s.charAt(i)==s.charAt(j)&&(j-i<2 || palin[i+1][j-1])) {  
					palin[i][j] = true;
					if(j==s.length()-1) 
						minCutArray[i] = 0;
					else
						minCutArray[i] = Math.min(minCutArray[i], minCutArray[j+1] + 1);
				}
			}
		}
		return minCutArray[0];
	}







	public static void getPalindromeMap(String s, boolean[][] palindromeMap) {
		if(s == null || s.length()==0)
			return;
		for(int i=s.length()-1;i>=0;i--) {
			for(int j=i;j<s.length();j++) {
				if(i==j)
					palindromeMap[i][j] = true;
				else if(s.charAt(i)==s.charAt(j)) {
					if(j==i+1 || palindromeMap[i+1][j-1])
						palindromeMap[i][j] = true;
				}
				else
					palindromeMap[i][j] = false;

			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
}
