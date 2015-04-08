
public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new PalindromeNumber().isPalindrome(10000021));

	}
	public boolean isPalindrome(int x) {
		if(x < 0)
			return false;
		
		int topDigit;
		int bottomDigit;
		int base = 1, temp;
		temp = x;
    	while(temp >= 10) {
    		temp = temp / 10;
    		base = 10 * base;
    	}
    	
        while(x > 0) {
     
        	topDigit = x /base;    
        	
        	bottomDigit = x%10;
        	
        	System.out.println(topDigit);
        	System.out.println(bottomDigit);
        	if(topDigit != bottomDigit) {
        		return false;
        	}
        	
        	x = (x % base)/10;
        	
        	base = base / 100;
        }
        return true;
    }

}
