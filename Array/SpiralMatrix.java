package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> result = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;
		int row = matrix.length;
		int column = matrix[0].length;
		int x1 = 0;
		int y1 = 0;
		int x2;
		int y2;
		
		while(row>0 && column>0) {
			x2 = x1 + row - 1;
			y2 = y1 + column - 1;

			for(int i=y1;i<=y2;i++)
				result.add(matrix[x1][i]);
			
			for(int i=x1+1;i<x2;i++)
				result.add(matrix[i][y2]);
			
			if(row > 1) {
				for(int i=y2;i>=y1;i--)
					result.add(matrix[x2][i]);
			}
			
			if(column > 1) {
				for(int i=x2-1;i>x1;i--)
					result.add(matrix[i][y1]);
			}
			
			row -=2;
			column -=2;
			x1++;
			y1++;
			
		}
		return result;
		
	}
}
