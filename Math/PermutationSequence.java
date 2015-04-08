package Math;

public class PermutationSequence {
	public static String getPermutation(int n, int k) {
		int[] arr = new int[n];

		int count = 1;
		for(int i=0;i<=n-1;i++) {
			count *= i + 1;
			arr[i] = i + 1;
		}
		String ans = "";
		k--;
		for(int i=n-1; i>=0; i--) {
			count = count / (i+1);
			int selected = k / count;
			ans = ans + arr[selected];
			//for(int j=selected; j+1<n; j++)   不用循环这么多次，第i次循环只有i+1个数
			for(int j=selected; j<i; j++)
				arr[j] = arr[j+1];
			
			k = k % count;
		}

		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(getPermutation(3,4));
	}
	
	
	
}
