package dynamicProgramming;

public class UniqueBinarySearchTrees {
	//fn = f0*fn-1 + f1*fn-2 ....
	public int numTrees(int n) {
		int[] sum = new int[n+1];
		sum[0] = 1;
		sum[1] = 1;
		for(int i=2;i<=n;i++) {
			for(int j=0;j<i;j++)
				sum[i] += sum[j]*sum[i-j-1];
		}
		return sum[n];
		
	}
}
