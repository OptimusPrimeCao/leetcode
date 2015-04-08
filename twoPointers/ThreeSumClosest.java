package twoPointers;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int closet = 0;
		int dis = Integer.MAX_VALUE;
		for(int k=0;k<num.length-2;k++) {
			int i = k+1;
			int j = num.length-1;
			while(i < j) {
				int sum = num[k]+num[i]+num[j];
				if(Math.abs(sum-target) < dis) {
					dis = Math.abs(sum-target);
					closet = sum;
				}
				
				if(sum > target) 
					j--;
				else if(sum < target) 
					i++;
				else
					return target;
				
				
			}
		}
		return closet;
	}
}
