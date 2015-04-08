package Math;

public class MultiplyStrings {
	public static String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0"))
			return "0";			
		String pre = "";
		for(int i=0;i<num2.length();i++) {
			String curStr = "0";
			int n = num2.charAt(i)-'0';
			for(int k=1;k<=n;k++)
				curStr = addStr(curStr, num1);
			
			pre = addStr((pre+"0"),curStr);
		}
		
		return pre;
	}
	
	public static String addStr(String a, String b) {
		if(a.equals("0"))
			return b;
		if(b.equals("0"))
			return a;
		
		int aLength = a.length();
		int bLength = b.length();
		int i = aLength - 1;
		int j = bLength - 1;
		int carry = 0;
		String result = "";
		int n =0;
		while(i >=0 && j >= 0) {
			n = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
			carry = n/10;
			int curdigit = n%10;
			result = curdigit + result;
			i--; j--;
		}
		while(i >=0) {
			n = a.charAt(i) - '0' + carry;
			carry = n/10;
			int curdigit = n%10;
			result = curdigit + result;
			i--; 
		}
		while(j >=0) {
			n = b.charAt(j) - '0' + carry;
			carry = n/10;
			int curdigit = n%10;
			result = curdigit + result;
			j--; 
		}
		if(carry == 1)
			result = "1" + result;
		return result;	
	}
	
	
	public static void main(String[] args) {
		System.out.println(multiply("2", "33"));
	}
}
