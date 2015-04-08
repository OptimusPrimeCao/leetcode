package Math;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		int carry = 1;
		for(int i=length-1; i>=0;i--) {
			int n = digits[i] + carry;
			if(n >= 10) {
				digits[i] = n - 10;
				carry = 1;
			}else {
				digits[i] = n;
				carry = 0;
			}
		}
		if(carry == 1) {
			int[] result = new int[length + 1];
			result[0] = 1;
			for(int i=1; i<length+1; i++) {
				result[i] = digits[i-1];
			}
			return result;
		}
		return digits;
	}
}
