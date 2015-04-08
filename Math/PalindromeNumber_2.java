package Math;

public class PalindromeNumber_2 {
	public static boolean isPalindrome(int x) {
		int base = 1;
		int n = x;
		if(x < 0)
			return false;
		while(n > 9) {
			n = n /10;
			base = base * 10;
		}
		int high;
		int low;

		while(base > 9) {
			high =  x / base;
			low = x % 10;
			if(high != low)
				return false;
			
			//x = (x - base * high - low) / 10;
			x = (x % base) / 10;
			base /= 100;
			
		}
		return true;
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(10^4);
		System.out.println(isPalindrome(10001));
	}
}
