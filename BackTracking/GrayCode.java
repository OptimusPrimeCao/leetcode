package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public static List<Integer> grayCode(int n) {
		List<Integer> nums = new ArrayList<Integer>();
		dfs(nums, n, true, 0);
		return nums;
		
	}
	
	public  List<Integer> wrongAns(int n) {
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(0);
		int pre = 0;
		for(int k=0;k<n;k++) {
			int cur = pre + (int)Math.pow(2, k);
			nums.add(cur);
			pre = cur;
		}
		for(int k=0;k<n-1;k++) {
			int cur = pre - (int)Math.pow(2, k);
			nums.add(cur);
			pre = cur;
		} 
		return nums;

	}
	public static void dfs(List<Integer> nums, int n, boolean zeroFirst, int legacy) {
		if(n == 0) {
			nums.add(legacy);
			return;
		}
		if(zeroFirst) {
			dfs(nums,n-1,true,legacy);           //由定义
			dfs(nums,n-1,false,(int)Math.pow(2, n-1)+legacy);  // 下1之后是上1
		}
		else {
			dfs(nums,n-1,true,(int)Math.pow(2, n-1)+legacy); //上1之后是下1
			dfs(nums,n-1,false,legacy); 				//下0之后是上1

		}
	}


	public static void main(String[] args) {
		System.out.println(grayCode(1));
	}
//	
//	vector<int> grayCode(int n) {  
//	    vector<int> result;  
//	    result.push_back(0);  
//	    for(int i=0; i<n;i++){  
//	        int highest = 1<<i;  
//	        int len = result.size();  
//	        for(int i=len -1; i>=0; i--){  
//	            result.push_back(highest+result[i]);  
//	        }  
//	    }  
//	    return result;  
//	}  
	


}
