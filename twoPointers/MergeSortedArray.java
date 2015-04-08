package twoPointers;

public class MergeSortedArray {
	public static void merge(int A[], int m, int B[], int n) {
		int[] result = new int[m + n];
		int k=0;
		int i=0,j=0;
		for(;i<m && j<n;k++) {
			if(A[i] > B[j]){
				result[k] = B[j];
				j++;
			}else {
				result[k] = A[i];
				i++;
			}
		}
		while(i < m) 
			result[k++] = A[i++];
		while(j < n) 
			result[k++] = B[j++];
		
		for(i=0;i<m+n;i++)
			A[i] = result[i];
		return;
	}
	public static void main(String[] args) {
		int[] A = new int[0];
		int[] B = {1};
		merge(A, 0, B, 1);
		
	}
}
