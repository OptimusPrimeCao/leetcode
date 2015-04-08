package BiteManipulation;

public class SingleNumber {
	public int singleNumber(int[] A) {
		int n = A[0];
		for(int i=1;i<A.length;i++)
			n = n^A[i];
		return n;
	}
}
