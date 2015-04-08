package BinarySearch;

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		int mid;
		while(low <= high) {
			mid = (low + high) / 2;
			if(target == A[mid])
				return mid;
			if(A[low] < A[mid]) {     // low~mid increase
				if(A[low] <= target && target < A[mid]) {
					if(A[low] == target)
						return low;
					high = mid - 1;
				}else {
					low = mid + 1;
				}

			}else if(A[low] > A[mid]){          //mid~high increase
				if(A[mid] < target && target <= A[high]) {
					if(A[high] == target)
						return high;
					low = mid + 1;
				}else {
					high = mid - 1;
				}			
			}else {
				low = mid + 1;
			}
			
		}

		return -1;


	}
	
	public static void main(String[] args) {
		System.out.println();
	}
}
