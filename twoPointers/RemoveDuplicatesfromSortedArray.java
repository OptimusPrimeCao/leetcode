package twoPointers;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		int start = 0;
		for(int i=0;i<A.length;i++) {
			if(i>0 && A[i] == A[i-1]) 
				continue;
			A[start++] = A[i];
			
		}
		return start;
	}
}
