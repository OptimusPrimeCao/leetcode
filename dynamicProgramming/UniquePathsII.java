package dynamicProgramming;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int rowLen = obstacleGrid.length;
		int colLen = obstacleGrid[0].length;
		int[][] paths = new int[rowLen][colLen];

		boolean hasObstacle = false;
		for(int i=0;i<colLen;i++) {
			if(obstacleGrid[0][i] == 1)
				hasObstacle = true;
			if(!hasObstacle)
				paths[0][i] = 1;
		}
		hasObstacle = false;
		for(int i=0;i<rowLen;i++) {
			if(obstacleGrid[i][0] == 1)
				hasObstacle = true;
			if(!hasObstacle)
				paths[i][0] = 1;
		}

		for(int i=1;i<rowLen;i++) {
			for(int j=1;j<colLen;j++) {
				if(obstacleGrid[i][j]==1)
					paths[i][j] = 0;
				else
					paths[i][j] = paths[i-1][j] + paths[i][j-1];
			}
		}


		return paths[rowLen-1][colLen-1];

	}
}
