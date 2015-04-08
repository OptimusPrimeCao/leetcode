package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
	public static int totalNQueens(int n) {
		int[] result = new int[1];
		int[] tagArr = new int[n];
		dfs(result, 0, n, tagArr);
		return result[0];
	} 

	public static void dfs(int[] result, int row, int n, int[] tagArr) {
		if(row == n) {
			result[0]++;
			return;
		}
		for(int k=0;k<n;k++) {
			if(isValid(row,k,tagArr)) {
				tagArr[row] = k;
				dfs(result, row+1, n, tagArr);
				tagArr[row] = -1;
			}
		}
	}
	public static boolean isValid(int row, int col, int[] tagArr) {
		for(int k=0;k<row;k++)
			if(tagArr[k] == col || Math.abs(tagArr[k]-col) == Math.abs(k-row)) 
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(totalNQueens(1));
		Integer result = new Integer(0);            //为避免设置int全局变量不能用Integer， 
		result++;										//Integer也为传值引用
		System.out.println(result);						//可以用数组第一个值（数组本身是引用）来代替
	}


}
