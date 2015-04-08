package Math;

import java.util.HashMap;
import java.util.Map;
public class FractionToRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		return doFraction((long)(numerator),(long)(denominator));
	}
	public static String doFraction(long numerator, long denominator) {
		if(denominator == 0)
			return "";
		boolean isPositive = true;
		if(numerator < 0 ^ denominator < 0) {
			isPositive = false;
		}
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);
		
		long quotient = numerator/denominator;
		long remnant = numerator%denominator;

		String result = String.valueOf(quotient);
		if(remnant == 0) 
			return isPositive?  result: "-" +  result;
		result = result + ".";
		Map<Long,Integer> exists = new HashMap<Long,Integer>();
		int loc = 0;
		String str = "";

		while(remnant != 0 && !exists.containsKey(remnant)) {
			exists.put(remnant, loc++);
			remnant = remnant * 10;
			quotient = remnant/denominator;
			remnant = remnant%denominator;
			str = str + String.valueOf(quotient);
		}
		
		if(remnant != 0) {
			loc = exists.get(remnant);
			String repeat = str.substring(loc);
			str = str.substring(0, loc) + "(" + repeat + ")";
		}	
		return isPositive? result + str: "-" + result + str;	
	}
	public static void main(String[] args) {
		System.out.println(10%100);
	}
}
