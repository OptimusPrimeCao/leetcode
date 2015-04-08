package Math;

public class AddBinary {
	public static String addBinary(String a, String b) {
		int aLength = a.length();
		int bLength = b.length();
		int i = aLength - 1;
		int j = bLength - 1;
		int carry = 0;
		String result = "";
		
		int n =0;
		while(i >=0 && j >= 0) {
			n = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
			carry = n/2;
			int curdigit = n%2;
			result = curdigit + result;
			i--; j--;
		}
		

		while(i >=0) {
			n = a.charAt(i) - '0' + carry;
			carry = n/2;
			int curdigit = n%2;
			result = curdigit + result;
			i--; 
		}
		while(j >=0) {
			n = b.charAt(j) - '0' + carry;
			carry = n/2;
			int curdigit = n%2;
			result = curdigit + result;
			j--; 
		}


		if(carry == 1)
			result = "1" + result;


		return result;

		
	}
	
	public static void main(String[] args) {
		System.out.println(addBinary("1010", "1011"));
	}
}
