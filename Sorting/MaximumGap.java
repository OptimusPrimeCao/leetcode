package Sorting;

import java.util.ArrayList;

public class MaximumGap {
	public static int maximumGap(int[] num) {
		if(num == null || num.length <=1)
			return 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<num.length;i++) {
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}
		
		int gap = (int)Math.ceil((double)(max - min)/num.length);
		int bucketsCount = (int)Math.ceil((double)(max - min)/gap);
		int[][] bucketArr = new int[bucketsCount][2];
		
		
		for(int i=0;i<bucketArr.length;i++) {
			for(int j=0;j<bucketArr[i].length;j++)
				bucketArr[i][0] = Integer.MIN_VALUE;
				bucketArr[i][1] = Integer.MAX_VALUE;
		}
		

		for(int i=0;i<num.length;i++) {
			int k = (num[i]-min)/gap;
			if(k == bucketsCount)
				k--;
			bucketArr[k][0] = Math.max(bucketArr[k][0], num[i]);
			bucketArr[k][1] = Math.min(bucketArr[k][1], num[i]);
		}

//
//		for(int i=0;i<bucketArr.length;i++) {
//			for(int j=0;j<bucketArr[i].length;j++)
//				System.out.print(bucketArr[i][j]);
//			System.out.println();
		//		}
		//		

		int preMax = bucketArr[0][0];
		int maxVal = Integer.MIN_VALUE;
		for(int i=1;i<bucketsCount;i++) {
			if(bucketArr[i][0]==Integer.MIN_VALUE)
				continue;
			maxVal = Math.max(bucketArr[i][1]-preMax, maxVal);
			preMax = bucketArr[i][0];
		}
		return maxVal;

	}


	public static void main(String[] args) {
		//(int)Math.ceil((max - min)/num.length);

		int[] a = new int[]{1,100000000};
		System.out.println(maximumGap(a));
		System.out.println((int)Math.ceil((double)(5 - 1)/10));
	}
}
