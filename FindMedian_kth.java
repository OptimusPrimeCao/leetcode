import java.math.*;
public class FindMedian_kth {

	public static void main(String[] args) {
		int A[] = {1,2,3,5,8};
		int B[] = {3,4,6};
		System.out.println(new FindMedian_kth().findMedianSortedArrays(A, B));
	}
	public double findMedianSortedArrays(int A[], int B[]) {
	    int m = A.length;
	    int n = B.length;
	    int k = m + n;
	    return k%2==0 ? (findKth(A, 0, m-1, B, 0, n-1, k/2) + findKth(A, 0, m-1, B, 0, n-1, k/2 + 1))/2 :
	    	         findKth(A, 0, m-1, B, 0, n-1, k/2 + 1);
	}
	public double findKth(int A[], int l1, int h1, int B[], int l2, int h2, int k) {
		int m = h1 - l1 + 1;
		int n = h2 - l2 + 1;
		if(l1 > h1) return B[k-1];
		if(l2 > h2) return A[k-1];
		if(m > n)  return findKth(B, l2, h2, A, l1, h1, k);
		if(k == 1) return Math.min(A[l1], B[l2]);
		int midA = Math.min(k/2, m); int midB = k - midA;
		if(A[l1 + midA - 1] < B[l2 + midB -1]) {
			return findKth(A, l1 + midA, h1, B, l2, h2, midB);
		}
		if(A[l1 + midA -1] > B[l2 + midB -1]) {
			return findKth(A, l1, h1, B, l2 + midB, h2, midA);
		}
		else {
			return A[l1 + midA - 1];
		}
	}
}
