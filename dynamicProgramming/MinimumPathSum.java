package dynamicProgramming;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if(grid == null)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		if(m == 0 || n == 0)
			return 0;
		int[][] minPath = new int[m][n];
		int sum = grid[0][0];
		minPath[0][0] = sum;
		for(int i=1;i<m;i++) {
			sum += grid[i][0];
			minPath[i][0] = sum;
		}

		sum = grid[0][0];
		for(int i=1;i<n;i++) {
			sum += grid[0][i];
			minPath[0][i] = sum;
		}
		for(int i=1;i<m;i++) 
			for(int j=1;j<n;j++) 
				minPath[i][j] = Math.min(minPath[i-1][j], minPath[i][j-1]) + grid[i][j];
		return minPath[m-1][n-1];
	}
}
