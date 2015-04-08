package BinarySearch;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class SearchA2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int rowLength = matrix.length;
		
		int high = rowLength - 1;
		int low = 0;
		int mid  = (high + low)/2;
		
		while(high >= low) {
			if(target < matrix[mid][0]) {
				high = mid - 1;
			}else if(target == matrix[mid][0]){
				return true;
			}else {
				low = mid + 1;
			}
			
			mid = (high + low)/2;
		}
	//high除了下越界情况外，就是target所在列的索引
		if(high == -1) 
			return false;
		
		
		int rowLoc = high;
		high = matrix[mid].length - 1;
		low = 0;
		mid = (high + low)/2;
		while(high >= low) {
			if(target < matrix[rowLoc][mid]) {
				high = mid - 1;
			}else if(target == matrix[rowLoc][mid]){
				return true;
			}else {
				low = mid + 1;
			}
			
			mid = (high + low)/2;
		}
		
		return false;
		
	}
	public static void main(String[] args) {
		int[][] A = {{1,1}};
		System.out.println(searchMatrix(A, 0));
	}
}
