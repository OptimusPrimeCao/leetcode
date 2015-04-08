package DivideAndConquer;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		if((m + n)%2==0)
			return (double)(findKth((m+n)/2,A,B,0,0) + findKth((m+n)/2+1,A,B,0,0))/2;
		else
			return (double)findKth((m+n)/2+1,A,B,0,0);
	}

	public int findKth(int k, int[] A, int[] B, int lA, int lB) {
		if(lA >= A.length)   	
			return B[k-1];
		if(lB >= B.length)
			return A[k-1];
		if(k==1)
			return A[lA] < B[lB] ? A[lA] : B[lB];
		
		int m = A.length-lA;
		int n = B.length-lB;
		if(m > n)
			return findKth(k, B, A, lB, lA);
		
		int pivotA = Math.min(m, k/2);
		int pivotB = k - pivotA;
		if(A[lA+pivotA-1] > B[lB+pivotB-1])
			return findKth(k-pivotB, A, B, lA, lB+pivotB);
		if(A[lA+pivotA-1] < B[lB+pivotB-1])
			return findKth(k-pivotA, A, B, lA+pivotA, lB);
		else
			return A[lA+pivotA-1];
	}
}
