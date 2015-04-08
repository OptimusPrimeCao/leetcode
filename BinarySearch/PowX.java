package BinarySearch;

public class PowX {
	public double pow(double x, int n) {
		if(n ==0)
			return 1;
		if(n < 0) {
			if(n == Integer.MIN_VALUE)
				return 1/(pow(x,Integer.MAX_VALUE)*x);
			return 1/pow(x, -n);
		}
		double result = pow(x,n/2);
		if(n%2 == 0) {
			return result*result;
		}	
		return result*result*x;

	}
	//按位移动n
	public double pow2(double x, int n) {
		if(n ==0)
			return 1;
		if(n < 0) {
			if(n == Integer.MIN_VALUE)
				return 1/(pow(x,Integer.MAX_VALUE)*x);
			return 1/pow(x, -n);
		}
		
		double result = 1;
		for(;n>0;x=x*x,n>>=1) {
			if((n&1)==1)
				result = result*x;
		}
		
		return result;

	}
	
	
	public static void main(String[] args) {
		
	}
}
