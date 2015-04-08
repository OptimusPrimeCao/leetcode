package greedy;

public class JumpGameII {
	public int jump(int[] A) {
		if(A == null || A.length <= 1)
			return 0;
		int curIndex = 0;
		int maxIndex = A[0];
		int count = 1;
		int nextIndex;
		boolean hasNext = false;
		while(maxIndex < A.length-1) {
			nextIndex = curIndex+1;
			hasNext = false;
			for(int i=nextIndex;i<=maxIndex;i++) {
				if(A[i]+i > maxIndex) {
					if(A[i]+i > A[nextIndex]+nextIndex)
						nextIndex = i;
					hasNext = true;
				}
			}
			if(hasNext == false)
				return -1;
			curIndex = nextIndex;
			maxIndex = A[curIndex]+curIndex;
			count ++;
		}
		return count;



	}

	public void dfs(int[] minStep, int A[], int curIndex, int step) {
		int maxIndex = curIndex + A[curIndex];
		int i;
		while(maxIndex < A.length-1) {
			for(i=curIndex+1;i<=maxIndex;i++) {
				if(i+A[i] > maxIndex) 
					dfs(minStep, A, i, step+1);	
			}
			if(i > maxIndex)
				return;	
		}
		if(minStep[0] > step + 1)
			minStep[0] = step + 1;

	}
}
