package BinarySearch;

public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
		boolean positive = ((dividend>=0) && (divisor>0)) || ((dividend<=0) && (divisor<0));
		long _dividend = Math.abs((long)dividend);
		long _divisor = Math.abs((long)divisor);
		long result = positive? absDivide(_dividend, _divisor) : -absDivide(_dividend, _divisor);
		if(result > Integer.MAX_VALUE)
			result = Integer.MAX_VALUE;
		return (int)result;
		
	}
	
	private static long absDivide(long dividend, long divisor) {
		if(divisor > dividend)
			return 0;
		long temp = divisor;
		long result = 1;
		long left = 0;
		while(temp < dividend) {
			left = dividend - temp;
			temp <<= 1;
			if(temp >= dividend)
				break;
			else
				result <<= 1;
		}
		
		return result + absDivide(left, divisor);
	}
	
	public static void main(String[] args) {
		System.out.println(divide(-2147483648, -1));	
	}
}
