
public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int singleNumber(int A[], int n) {
	    int ones = 0, twos = 0, xthrees = 0;
	    for(int i = 0; i < n; ++i) {
	        twos |= (ones & A[i]);
	        ones ^= A[i];
	        xthrees = ~(ones & twos);
	        ones &= xthrees;
	        twos &= xthrees;
	    }

	    return ones;
	}

}
