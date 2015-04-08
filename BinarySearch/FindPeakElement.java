package BinarySearch;

public class FindPeakElement {
	public int findPeakElement(int[] num) {
		int low = 0;
		int high = num.length-1;
		if(num.length <= 1)
			return 0;
		int mid = 0;
		while(low <= high) {
			mid = (low + high)/2;
			if((mid == 0 && num[mid]>num[mid+1]) || (mid == num.length-1 && num[mid]>num[mid-1]) || (mid>0 && mid<num.length-1 && num[mid]>num[mid-1] && num[mid]>num[mid+1]))
				break;
			
			if(num[mid]<num[mid+1])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return mid;
		
	}
}
