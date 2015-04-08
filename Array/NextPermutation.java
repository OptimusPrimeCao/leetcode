package Array;

import java.util.Arrays;

public class NextPermutation {
	public static void nextPermutation(int[] num) {
		int len = num.length;
		int base = 0;
		int i,j;
		if(len == 1)
			return;
		for(i=len-2;i>=0;i--) {
			if(num[i]<num[i+1]) {
				base = num[i];
				break;
			}
		}
		if(i<0) {
			Arrays.sort(num);
			return;
		}
		
		for(j=i+1;j<len && num[j]>base;j++);
		
		
		int temp;
		temp = num[j-1];
		num[j-1] = num[i];
		num[i] = temp;
		
		Arrays.sort(num, i+1, len);
		
		
		
	}
	
	public static void main(String[] args) {
		int[] n = {2,3,1};
		nextPermutation(n);
		for(int i=0;i<n.length;i++)
			System.out.println(n[i]);
	}
}
