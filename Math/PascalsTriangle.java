package Math;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> preRow = null;
		ArrayList<Integer> curRow = null;
		for(int i=0; i<numRows; i++) {
			curRow = new ArrayList<Integer>();
			for(int j=0; j<i+1;j++) {
				if(j == 0) {
					curRow.add(1);
					continue;
				}
				if(j == i) {
					curRow.add(1);
					continue;
				}
				int n = preRow.get(j-1) + preRow.get(j);
				curRow.add(n);
			}
			result.add(curRow);
			preRow = curRow;
		}
		
		return result;
		
	}
	
	
	public static void main(String[] args) {
		generate(3);
	}
}
