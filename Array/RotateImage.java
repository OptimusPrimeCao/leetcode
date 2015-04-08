package Array;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if(matrix == null)
			return;
		int n = matrix.length;
		
		int x1 = 0;
		int y1 = 0;
		int x2;
		int y2;
		int temp;

		while(n > 1) {
			x2 = x1 + n - 1;
			y2 = y1 + n - 1;

			for(int i=1;i<=n-2;i++) {
				//swap((matrix[x1][y1+i]),matrix[x1+i][y2]);
				temp = matrix[x1][y1+i];
				matrix[x1][y1+i] = matrix[x1+i][y2];
				matrix[x1+i][y2] = temp;
				
			}
			

			for(int i=1;i<=n-2;i++) {
				//swap((matrix[x1][y1+i]),matrix[x2][y2-i]);
				temp = matrix[x1][y1+i];
				matrix[x1][y1+i] = matrix[x2][y2-i];
				matrix[x2][y2-i] = temp;
				
			}

			for(int i=1;i<=n-2;i++) {
				//swap((matrix[x1][y1+i]),matrix[x2-i][y1]);
				temp = matrix[x1][y1+i];
				matrix[x1][y1+i] = matrix[x2-i][y1];
				matrix[x2-i][y1] = temp;
			}
			
			temp = matrix[x1][y1];
			matrix[x1][y1] = matrix[x2][y1];
			matrix[x2][y1] = matrix[x2][y2];
			matrix[x2][y2] = matrix[x1][y2];
			matrix[x1][y2] = temp;

			n -=2;
			x1++;
			y1++;

		}
		return;
	}
	
	public static void main(String[] args) {
		int[][] A = {{123},{456},{789}};
		
	}
}
