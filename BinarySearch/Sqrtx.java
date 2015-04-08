package BinarySearch;

public class Sqrtx {
	public static int sqrt(int x) {
		if(x == 0)
			return 0;
		if(x == 1) 
			return 1;
		int low = 1;
		int high = x - 1;
		int mid = (low + high)/2;
		
		long x2Long = (long)x;
		while(high >= low) {
			if((long)mid * mid < x2Long) {
				low = mid + 1;
			}else if((long)mid * mid > x2Long) {
				high = mid - 1;
			}else {
				return mid;
			}
			 mid = (low + high)/2;
		}
	//high就是界限	
		return high;
		
	}
	public static void main(String[] args) {
		System.out.println(sqrt(2147395599));
		System.out.println((long)2147395599 * 2147395599);
	}
}
