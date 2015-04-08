package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumCloset {
	public int threeSumClosest(int[] num, int target)  {
		Arrays.sort(num);
		int result = num[0] + num[1] + num[2];
		for(int i=0;i<num.length;i++) {
			if(i>0 && num[i]==num[i-1])
				continue;

			int j = i+1;
			int k = num.length-1;
			while(j<k) {
				if(j>i+1 && num[j]==num[j-1]) {
					j++;
					continue;
				} 

				if(k<num.length-1 && num[k]==num[k+1]) {
					k--;
					continue;
				}
				int sum = num[i] + num[j] + num[k];
				
				if(Math.abs(result-target) > Math.abs(sum-target))
					result = sum;
				
				if(sum > target) {
					k--;
				}
				else if(sum < target) {
					j++;
				}else {
					return sum;
				}

			}
		}

		return result;
	}
}
