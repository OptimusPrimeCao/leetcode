package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		dfs(result,candidates,0,target,new ArrayList<Integer>());
		return result;
	}
	//candidates如果有重复元素这个方法会返回重复结果！
	public void dfs(List<List<Integer>> result,int[] candidates, int curIndex, int target, List<Integer> legacy) {
		if(target == 0) {
			result.add(legacy);
			return;
		}
		if(target > 0 && curIndex < candidates.length) {
			dfs(result, candidates, curIndex+1, target, legacy);
			List<Integer> listWithCurNum = new ArrayList<Integer>(legacy);
			listWithCurNum.add(candidates[curIndex]);
			dfs(result, candidates, curIndex, target-candidates[curIndex], listWithCurNum);
		}
	}
}
