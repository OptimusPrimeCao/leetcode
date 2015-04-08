package BinarySearch;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		int mid;
		while(low <= high) {
			mid = (low + high) / 2;
			if(A[mid] == target) 
				return true;
			if(A[low] < A[mid]) {
				if(A[low] <= target && target < A[mid]) {
					if(A[low] == target)
						return true;
					high = mid - 1;
				}
				else {
					low = mid + 1;
				}
			}else if(A[low] > A[mid]) {
				if(A[mid] < target && target <= A[high]) {
					if(A[high] == target)
						return true;
					low = mid + 1;
				}else {
					high = mid - 1;
				}	
			}else {		
				low = low + 1;
			}
			
		}
		return false;
	}
}
