package BinarySearch;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		int mid = (low + high) / 2;
		
		while(low <= high) {
			if(target > A[mid]) {
				low = mid + 1;
			}else if (target < A[mid]) {
				high = mid - 1;
			}else {
				return mid;
			}
			mid = (low + high) / 2;
		}
		return high + 1;
		
	}
}
