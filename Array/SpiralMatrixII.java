package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int [][] result = new int[n][n];
		int row = n;
		int column = n;
		int x1 = 0;
		int y1 = 0;
		int x2;
		int y2;
		int num = 1;

		while(row>0 && column>0) {
			x2 = x1 + row - 1;
			y2 = y1 + column - 1;

			for(int i=y1;i<=y2;i++)
				result[x1][i] = num++;

			for(int i=x1+1;i<x2;i++)
				result[i][y2] = num++;

			if(row > 1) {
				for(int i=y2;i>=y1;i--)
					result[x2][i] = num++;
			}

			if(column > 1) {
				for(int i=x2-1;i>x1;i--)
					result[i][y1] = num++;
			}

			row -=2;
			column -=2;
			x1++;
			y1++;

		}
		return result;
	}
}
