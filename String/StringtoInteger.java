package String;

public class StringtoInteger {
	public static int atoi(String str) {
		if(str == null || str.isEmpty())
			return 0;
		str = str.trim();
		if(str == null || str.isEmpty())
			return 0;
		
		char sign = str.charAt(0);
		int i = 0;
		long n = 0;
		if(sign == '+' || sign == '-')
			i++;
		
		while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <='9') {
			n = 10 * n + str.charAt(i) - '0';
			if(n > Integer.MAX_VALUE) 
				break;
			i++;
			
		}
		
		if(sign == '-') {
			n = -n;
			if(n < Integer.MIN_VALUE)
				n = Integer.MIN_VALUE;
		}
		else if(n > Integer.MAX_VALUE) {
			n = Integer.MAX_VALUE;
		}
		return (int)n;
	}
	
	public static void main(String[] args) {
		System.out.println(atoi("123"));
		// 19行换成大于等于Integer.MAX_VALUE + 1不对，因为已经超出int范围了，加出来是负数
		System.out.println(Integer.MAX_VALUE + 1);
	}
}
