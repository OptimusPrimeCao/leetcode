package BinarySearch;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] num) {
		int low = 0;
		int high = num.length-1;
		while(low<=high) {
			if(num[low] < num[high])
				return num[low];
			
			int mid = (low+high)/2;
			if(num[low] < num[mid]) 
				low = mid + 1;
			else if(num[low] > num[mid])
				high = mid;
			else {
				break;
			}
		}
		return Math.min(num[low], num[high]);
	}
	
	public int findMin2(int[] num) {
		int low = 0;
		int high = num.length-1;
		while(low<=high) {
			if(num[low] < num[high])
				return num[low];
			
			int mid = (low+high)/2;
			if(num[low] < num[mid]) 
				low = mid + 1;
			else if(num[low] > num[mid])
				high = mid;
			else {
				if(low == high - 1 || low == high)
					break;
				for(int i=low+1;i<=mid;i++)
					if(num[i] < num[i-1])
						return num[i];
				low = mid;
				
			}
		}
		return Math.min(num[low], num[high]);
	}
}
