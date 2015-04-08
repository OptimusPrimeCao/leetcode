package twoPointers;

public class SortColors {
	public static void sortColors(int[] A) {
		int len = A.length;
		int left1 = 0;
		int right1 = len-1;
		int i = 0;
		while(i<=right1) {
			if(A[i] == 0) {
				if(i > left1) {
					A[i] = A[left1];
					A[left1] = 0;
					left1++;
				}else {
					i++;
				}
			}
			else if(A[i] == 2){
				if(i < right1) {
					A[i] = A[right1];
					A[right1] = 2;
					right1--;
				}else {
					i++;
				}
			}else {
				i++;
			}
		}

	}

	public static void main(String[] args) {
//		int[] A = {2,0,0};
//		sortColors(A);
//		for(int i=0;i<A.length;i++)
//			System.out.println(A[i]);
		System.out.println(String[].class);
		System.out.println(String.class);
	}
	
}
