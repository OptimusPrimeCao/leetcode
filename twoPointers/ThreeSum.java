package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*双指针问题尤其注意，尽量用if-continue不用while，每一步实现指针的变动*/
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(num);
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
				//如果用while，1要判断外部条件j<k，2还要在外部条件不满足时跳出循环
				/*
				 * 
				 * while(j>i+1 && j<k && num[j]==num[j-1] )
					j++;
				   while(k<num.length-1 && j<k && num[k]==num[k+1])
					k--;
				   if(j == k)
				    break;
				 * 
				 */
				if(k<num.length-1 && num[k]==num[k+1]) {
					k--;
					continue;
				}
				int sum = num[i] + num[j] + num[k];
				if(sum > 0) {
					k--;
				}
				else if(sum < 0) {
					j++;
				}else {
					ArrayList<Integer> arr = new ArrayList<Integer>();
					arr.add(num[i]);
					arr.add(num[j]);
					arr.add(num[k]);
					result.add(arr);
					j++; k--;
				}
				
			}
		}
		
		return result;
	}
}
