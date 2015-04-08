package twoPointers;

public class TrappingRainWater {
	public int trap(int[] A) {
		if(A == null || A.length <= 2)
			return 0;
		int max_index = 0;
		int length = A.length;
		int waterSum = 0;
		for(int i=0; i<length;i++) {
			if(A[i] > A[max_index]) {
				max_index = i;
			}
		}
		
		int leftMax = A[0];
		for(int i=1;i<max_index;i++) {
			if(A[i] > leftMax) {
				leftMax = A[i];
			}else {
				waterSum += leftMax - A[i];
			}
		}
		
		int rightMax = A[length-1];
		for(int i=length-2;i>max_index;i--) {
			if(A[i] > rightMax) {
				rightMax = A[i];
			}else {
				waterSum += rightMax - A[i];
			}
		}
		return waterSum;
	}
}
