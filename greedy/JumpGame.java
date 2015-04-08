package greedy;

public class JumpGame {
	public static boolean canJump(int[] A) {
		if(A == null || A.length == 0)
			return true;

		int start = 0;
		int maxIndex = A[0];
		int i;
		while(maxIndex < A.length-1) {
			for(i=start+1;i<=maxIndex;i++) {
				if(A[i] + i > maxIndex) {
					maxIndex = A[i] + i;
					start = i;
					break;
				}
			}
			if(i > maxIndex)
				return false;
			
		}
		return true;

	}
	
	public static void main(String[] args) {
		System.out.println(canJump(new int[]{2,3,1,1,4}));
	}
}
