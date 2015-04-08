package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		if(n < k)
			return nums;
		dfs(n,1,k,nums,new ArrayList<Integer>());
		return nums;
	}

	public void dfs(int n, int curNum, int k, List<List<Integer>> nums , List<Integer> legacy) {
		if(k == 0) {
			nums.add(legacy);
			return;
		}
		if(curNum > n)	return;
		dfs(n,curNum+1,k,nums,legacy);
		List<Integer> curNumInList = new ArrayList<Integer>(legacy);
		curNumInList.add(curNum);
		dfs(n,curNum+1,k-1,nums,curNumInList);
	}
	
//	错误代码：不是++,--!.而是+1，-1
//	public void dfs(int n, int curNum, int k, List<List<Integer>> nums , List<Integer> legacy) {
//		if(k == 0) {
//			nums.add(legacy);
//			return;
//		}
//		if(curNum > n)	return;
//		dfs(n,curNum++,k,nums,legacy);
//		List<Integer> curNumInList = new ArrayList<Integer>(legacy);
//		curNumInList.add(curNum);
//		dfs(n,curNum++,k--,nums,curNumInList);
//	}
//	
	
}
