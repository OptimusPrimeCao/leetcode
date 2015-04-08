package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*也可以用hashtable去重*/
public class FourSum {
	public static List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>>  result = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		int length = num.length;
		for(int i=0; i<length; i++) {
			if(i>0 && num[i]==num[i-1]) 
				continue;
			for(int j=i+1;j<length;j++) {
				if(j>i+1 && num[j]==num[j-1]) 
					continue;
			

				int t = j+1;
				int k = length-1;
				int sum = 0;
				while(t<k) {
					if(t>j+1 && num[t]==num[t-1]) {
						t++;
						continue;
					}
					if(k<length-1 && num[k]==num[k+1]) {
						k--;
						continue;
					}

					sum = num[i] + num[j] + num[t] + num[k];
					if(sum > target) {
						k--;
					}
					else if(sum < target) {
						t++;
					}
					else {
						List<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[t]);
						list.add(num[k]);
						result.add(list);
						t++;
						k--;
					}

				}


			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] A = {-1,0,1,2,-1,-4};
		fourSum(A, -1);
	}
}
