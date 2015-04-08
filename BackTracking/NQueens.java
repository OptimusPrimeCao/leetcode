package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<String[]> solveNQueens(int n) {
		List<String[]> result = new ArrayList<String[]>();
		int[] tagArr = new int[n];
		dfs(result, 0, n, tagArr, new String[n]);
		return result;
	}

	public void dfs(List<String[]> result, int row, int n, int[] tagArr, String[] legacy) {
		if(row == n) {
			result.add(legacy);
			return;
		}
		for(int k=0;k<n;k++) {
			if(isValid(row,k,tagArr)) {
				String[] curStrArr = new String[n];
				for(int i=0;i<row;i++) 
					curStrArr[i] = legacy[i];
				String curStr = "";
				for(int i=0;i<n;i++)
					if(i != k)
						curStr = curStr + ".";
					else
						curStr = curStr + "Q";
				tagArr[row] = k;
				curStrArr[row] = curStr;
				dfs(result, row+1, n, tagArr, curStrArr);
				tagArr[row] = -1;
			}
		}

	}
	
	
	public boolean isValid(int row, int col, int[] tagArr) {
		for(int k=0;k<row;k++)
			if(tagArr[k] == col || Math.abs(tagArr[k]-col) == Math.abs(k-row)) 
				return false;
		return true;
	}
	



}
