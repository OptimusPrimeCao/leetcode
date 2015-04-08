package Math;
//注意越界，正负
public class ReverseInteger {
	public static int reverse(int x) {
		long result = 0;
		boolean isPositive = true;
		if(x < 0) {
			if(x == Integer.MIN_VALUE)
				return 0;
			x = -x;
			isPositive = false;
		}
		while(x > 0) {
			int k = x % 10;
			result = result * 10 + k;
			if(result > Integer.MAX_VALUE)
				return 0;
			x = (x - x%10)/10;
		}
		
		if(!isPositive)
			result = -result;
		return (int)result;
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(-2147483648));
	}
}
