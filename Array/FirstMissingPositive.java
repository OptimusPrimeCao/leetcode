package Array;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] A) {
		if(A == null || A.length == 0)
			return 1;
		int length = A.length;
		int temp;
		for(int i=0;i<length;i++) {
			while(A[i] != i+1 && A[i] >= 1 && A[i] <= length && A[i] != A[A[i]-1]) {
				//	swap(A[i], A[A[i]-1]);	  并没有交换，java int不能传引用
//				temp = A[i];
//				A[i] =  A[A[i]-1]; 
//				A[A[i]-1] = temp;         A[i]已经变了！应该是A[temp-1]=temp
				temp = A[A[i]-1];
				A[A[i]-1] = A[i];
				A[i] = temp;

			}
		}
		
		for(int i=0;i<length;i++) {
			if(A[i] != i+1)
				return i + 1;
		}
		return length + 1;
	}
	
	
	//
//	private static void swap(int a,int b) {
//		int temp;
//		temp = a;
//		a = b;
//		b = temp;
//	}
	
	public static void main(String[] args) {
		int[] A={2,1};
		System.out.println(firstMissingPositive(A));
	}
}
