package dynamicProgramming;

import java.util.Stack;

public class MaximalRectangle {
	public static int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		markDp(dp,matrix);
		int max = 0;
		for(int i=0;i<m;i++) 
			max = Math.max(max,getRowMax(dp[i]));
		return max;
	}
	
	public static void markDp(int[][] dp, char[][] matrix) {
		for(int j=0;j<matrix[0].length;j++) {
			for(int i=0;i<matrix.length;i++) {
				if(i==0)
					dp[i][j] = matrix[i][j]-'0';
				else {
					if(matrix[i][j] == '1')
						dp[i][j] = dp[i-1][j]+1;
					else
						dp[i][j] = 0;
				}
			}
		}
	}
	
	public static int getRowMax(int[] A) {
		Stack<Integer> ss = new Stack<Integer>();
		int max = Integer.MIN_VALUE;
		int i=0;
		while(i<A.length) {
			if(ss.isEmpty() || A[ss.peek()] <= A[i])
				ss.push(A[i++]);
			else {
				int highestIndex = ss.pop();
				max = Math.max(max, A[highestIndex]*(ss.isEmpty()?i:i-ss.peek()-1));
			}
		}

		while(!ss.isEmpty()) {
			int highestIndex = ss.pop();
			max = Math.max(max, A[highestIndex]*(ss.isEmpty()?A.length:A.length-ss.peek()-1));
		}
		return max;
	}
	public static void main(String[] args) {
		char[][] s = new char[][]{{'0','1'},{'0','1'}};
		System.out.println(maximalRectangle(s));
	}
	
}

