package Array;

//注意第一行

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		
		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;
		
		for(int i=0;i<rowLen;i++)
			if(matrix[i][0] == 0) {
				firstColHasZero = true;
				break;
			}
		for(int j=0;j<colLen;j++)
			if(matrix[0][j] == 0) {
				firstRowHasZero = true;
				break;
			}
		
		
		
		for(int i=0;i<rowLen;i++) {
			for(int j=0;j<colLen;j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
					
				}
			}
		}
		
		for(int i=1;i<rowLen;i++) {
			for(int j=1;j<colLen;j++) {
				if(matrix[0][j]==0 || matrix[i][0]==0)
					matrix[i][j] = 0;
			}
		}
		
		if(firstRowHasZero)
			for(int j=0;j<colLen;j++)
				matrix[0][j] = 0;
		
		if(firstColHasZero)
			for(int i=0;i<rowLen;i++)
				matrix[i][0] = 0;
		
		
		
		return;
		
		
	}
}
