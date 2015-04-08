package BinarySearch;

public class Search4ARange {
	public int[] searchRange(int[] A, int target) {
		int length = A.length;

		int high = length - 1;
		int low = 0;
		int mid  = (high + low)/2;

		int start;
		int end;
		
		int j;
		int[] result = new int[2];
		
		while(high >= low) {
			if(target < A[mid]) {
				high = mid - 1;
			}else if(target == A[mid]){
				j = mid - 1;
				while(j>=0 && target == A[j])
					j--;
				start = j + 1;
				
				j = mid + 1;
				while(j<length && target == A[j])
					j++;
				
				end = j - 1;
				result[0] = start;
				result[1] = end;
				return result;
				
			}else {
				low = mid + 1;
			}

			mid = (high + low)/2;
		}
		result[0] = -1;
		result[1] = -1;
 		return result;
	}
}
