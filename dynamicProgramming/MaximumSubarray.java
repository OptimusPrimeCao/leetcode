package dynamicProgramming;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int maxWithI = A[0];
		int maxSum = A[0];
		for(int i=1;i<A.length;i++) {
			maxWithI = Math.max(A[i],maxWithI+A[i]);
			maxSum = Math.max(maxWithI, maxSum);
		}
		return maxSum;
		
	}
	
	//上面的方法只用一遍，且节约空间，下面的方法也可只用一遍，但需要 一个数组
	public int firstCase(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int[] maxWithI = new int[A.length];
		maxWithI[0] = A[0];
		for(int i=1;i<A.length;i++) 
			maxWithI[i] = Math.max(A[i], maxWithI[i-1]+A[i]);
		
		int max = maxWithI[0];
		for(int i=1;i<A.length;i++)
			if(maxWithI[i] > max)
				max = maxWithI[i];
		return max;
	}
//   分治算法，网上的拷贝算法	
//	public int maxSubArray(int[] A) {  
//		int res  = Integer.MIN_VALUE;  
//		return getMaxSubarray(A, 0, A.length-1, res);  
//	}  
//	public int getMaxSubarray(int A[],int left, int right, int smax){  
//		if(left>right)  
//			return Integer.MIN_VALUE;  
//		int mid = (left+right)/2;  
//		int lmax = getMaxSubarray(A,left,mid-1,smax);  
//		int rmax = getMaxSubarray(A,mid+1,right,smax);  
//		smax = Math.max(lmax,smax);  
//		smax = Math.max(rmax,smax);  
//		int sum =0, mlmax = 0;  
//		for(int i=mid-1;i>=left;i--){  
//			sum+=A[i];  
//			if(sum>mlmax)  
//				mlmax = sum;  
//		}  
//		sum = 0;  
//		int mrmax = 0;  
//		for(int i=mid+1;i<=right;i++){  
//			sum+=A[i];  
//			if(sum>mrmax)  
//				mrmax = sum;  
//		}  
//		smax = Math.max(smax, mlmax+mrmax+A[mid]);  
//		return smax;  
//	}  
}
