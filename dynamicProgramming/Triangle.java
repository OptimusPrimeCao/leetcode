package dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] mins = new int[triangle.size()];
		int[] lastMins = new int[triangle.size()];
		lastMins[0] = 0;
 		for(List<Integer> row : triangle) {
 			int i=0;
 			for(Integer curNum : row) {
 				if(i==0) 
 					mins[i] = curNum + lastMins[i];
 				else if(i==row.size()-1)
 					mins[i] = curNum + lastMins[i-1];
 				else
 					mins[i] = curNum + Math.min(lastMins[i-1],lastMins[i]);
 				i++;
 			}
 			for(int k=0;k<i;k++)
 				lastMins[k] = mins[k];

 		}

 		Arrays.sort(mins);
 		return mins[0];

	}
}
