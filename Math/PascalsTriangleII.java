package Math;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	 public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		int preRowjNum = 0;
		int preRowPrejNum = 1;
		
		int[] curRow = new int[rowIndex+1];
		curRow[0] = 1;
		for(int i=0; i<rowIndex+1; i++) {
			for(int j=1; j<i+1;j++) {
				if(j == i) {
					curRow[j] = 1;
					continue;
				}
				preRowjNum = curRow[j];
				curRow[j] = preRowPrejNum + curRow[j];
				preRowPrejNum = preRowjNum;
			}
		}
		for(int i=0; i<rowIndex+1; i++) 
			result.add(curRow[i]);
		
		return result;
		
	}
	 
	 public static void main(String[] args) {
		System.out.println(getRow(4));
	}
}
