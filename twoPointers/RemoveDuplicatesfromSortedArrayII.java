package twoPointers;
//双指针，当快需要过去信息作判断时要考虑慢指针已经覆盖了过去信息的情况
public class RemoveDuplicatesfromSortedArrayII {
	public static int removeDuplicates(int[] A) {
		int start = 0;
		for(int i=0;i<A.length;i++) {
			if(i>1 && A[i] == A[i-2]){
				if(i==start+1 && A[i] != A[i-3]) {				
				}
				else
					continue;
			}
			A[start++] = A[i];
		}
		return start;
	}
	
	 //更好的方法。1 增加计数器，只有达到数值才进位     
	// 			   2 i-1这个数不会被覆盖
	public static int removeDuplicates2(int[] A) {
		int start = 0;
		int repeat = 0;
		for(int i=0;i<A.length;i++) {
			if(i>0 && A[i] == A[i-1]){
				repeat++;
			}else {
				repeat = 0;
			}	
			if(repeat >= 2) {
				continue;
			}
			A[start++] = A[i];
		}
		return start;
	}
	
	public static void main(String[] args) {
		int[] A = {1,1,1};
		removeDuplicates(A);
		for(int i=0;i<A.length;i++)
			System.out.println(A[i]);
	}
}
