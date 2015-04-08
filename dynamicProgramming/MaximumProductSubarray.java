package dynamicProgramming;

public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		int curMin = A[0];
		int curMax = A[0];
		int result = A[0];
		for(int i=1; i<A.length;i++) {
			int temp = A[i]*curMin;
			curMin = Math.min(curMax*A[i], Math.min(temp, A[i]));
			curMax = Math.max(curMax*A[i], Math.max(temp, A[i]));
			result = Math.max(result, curMax);
		}
		return result;
	}
}
